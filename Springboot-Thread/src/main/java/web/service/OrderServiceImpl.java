package web.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.entity.Request;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author : dafeng.guo
 * @date : 21:43 2022/4/17
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    LinkedBlockingDeque<Request> queue = new LinkedBlockingDeque<>();
    @Override
    public Map<String,Object> testJuc(String orderCode) throws ExecutionException, InterruptedException {
        //生成请求的唯一标识
        String serialNo = UUID.randomUUID().toString();
        CompletableFuture<Map<String,Object>> future = new CompletableFuture<>();
        Request request = Request.builder()
                .orderCode(orderCode)
                .serialNo(serialNo)
                .future(future)
                .build();
        queue.add(request);
        return future.get(); //阻塞的监听获取线程请求结果
    }

    /**
     * 每隔十毫米
     */
    @PostConstruct
    public void init() {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                int size = queue.size();
                if (size == 0){
                    return;
                }
                List<Map<String,String>> batchParam= new ArrayList<>();
                List<Request> requests = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Request request = queue.poll();
                    Map<String, String> map = new HashMap<>();
                    map.put("orderCode",request.getOrderCode());
                    map.put("serialNo",request.getSerialNo());
                    batchParam.add(map);
                    requests.add(request);
                }
                log.info("批量处理的数据量{}",size);
                List<Map<String, Object>> responses = batchQueryOrderInfo(batchParam);
                for (Request request : requests){
                    String serialNo = request.getSerialNo();
                    for (Map<String, Object> response : responses) {
                        if (Objects.equals(serialNo,String.valueOf(response.get("serialNo")))){
                            request.getFuture().complete(response);
                            break;
                        }
                    }
                }
            }
        },0,10,TimeUnit.MILLISECONDS);
    }
    /**
     * 模拟远程调用批量查询订单接口 略
     * @return
     */
    public List<Map<String,Object>> batchQueryOrderInfo(List<Map<String,String>> list){
        /**
         * 伪代码暂时省略
         */
        return new ArrayList<>();
    }
}
