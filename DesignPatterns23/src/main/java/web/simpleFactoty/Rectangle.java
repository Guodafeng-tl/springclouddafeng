package web.simpleFactoty;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 13:50 2021/4/22
 * 长方形类实现图形接口，画一个长方形
 **/
@Slf4j
public class Rectangle implements Shape{
    @Override
    public void draw() {
        log.info("******************************画一个长方形Rectangle");
    }
}
