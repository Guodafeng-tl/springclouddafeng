package web.simpleFactoty;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 13:55 2021/4/22
 * 正方形
 **/
@Slf4j
public class Square implements Shape{
    @Override
    public void draw() {
        log.info("******************************画一个正方形Square");
    }
}
