package web.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author : dafeng.guo
 * @date : 21:52 2022/4/17
 * 线程请求对象
 **/
@Data
@Builder
public class Request {
    String orderCode;
    //请求的唯一标识
    String serialNo;
    //返回结果
    CompletableFuture<Map<String,Object>> future;
}
