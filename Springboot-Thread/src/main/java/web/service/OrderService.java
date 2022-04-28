package web.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author : dafeng.guo
 * @date : 21:42 2022/4/17
 **/
public interface OrderService {
    public Map<String,Object> testJuc(String orderCode) throws ExecutionException, InterruptedException;
}
