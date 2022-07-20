package web.controller.ThreadSplitList;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * @author : dafeng.guo
 * @date : 15:02 2022/07/17
 **/
@Slf4j
public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(4, 8,
                1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        List<String> list = Lists.newArrayList();
        int size = 51;
        for (int i = 0; i < size; i++) {
            list.add("hello-" + i);
        }
        Function<String,String> function = str->str+"dafeng";

        // 大集合里面包含多个小集合
        List<List<String>> splitList = SplitListUtils.split(list, 5);
        final List<Future<Map<String,List<String>>>> futureList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(splitList.size());
        AtomicInteger taskCounter = new AtomicInteger(0);
        for (List<String> datas : splitList) {
            Callable<Map<String,List<String>>> callable= ()->{
                Map<String, List<String>> map = new HashMap<>();

                final List<String> result = new ArrayList<>(list.size());
                datas.stream().forEach(element->{
                    result.add(function.apply(element));
                });
                map.put(Thread.currentThread().getName(),result);
                return map;
            };
            Future<Map<String,List<String>>> submit = threadPoolExecutor.submit(callable);
            futureList.add(submit);

        }
        List<String> processResult = Lists.newArrayList();
        for (Future<Map<String,List<String>>> future : futureList) {
            try {
                Map<String, List<String>> map = future.get();
                map.forEach((key,value)->{
                    log.info("当前线程名称"+key+"当前线程处理的数据"+value);
                    processResult.addAll(value);
                });
            }catch (Exception e){

            }finally {
                System.out.println("当前countDownLatch值"+countDownLatch);
                countDownLatch.countDown();
            }
        }
        System.out.println("最终的countDownLatch值"+countDownLatch);
        try {
            countDownLatch.await();
            log.info("线程处理后的结果：{}",processResult);
        }catch (Exception e){
            log.error("阻塞等待异常，{}", e);
        }

    }

}
