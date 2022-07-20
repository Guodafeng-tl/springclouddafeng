package web.controller;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/**
 * @author : dafeng.guo
 * @date : 9:42 2022/7/15
 **/
@Slf4j
public class GoogleCacheTest {

    private static final Cache<String,Object> CACHE = CacheBuilder.newBuilder().
            concurrencyLevel(Runtime.getRuntime().availableProcessors()).
            initialCapacity(5000).maximumSize(50000).expireAfterAccess(2, TimeUnit.HOURS).build();

    public static  Object get(String key, Callable callable){
        try {
            return CACHE.get(key,callable);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (CacheLoader.InvalidCacheLoadException e2){
            return null;
        }
    }
}
