package web.simpleFactoty;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 13:57 2021/4/22
 **/
@Slf4j
public class Circle implements Shape{
    @Override
    public void draw() {
        log.info("******************************画一个圆形circle");
    }
}
