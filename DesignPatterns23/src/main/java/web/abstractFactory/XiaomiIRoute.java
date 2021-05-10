package web.abstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 15:02 2021/4/26
 **/
@Slf4j
public class XiaomiIRoute implements IRouteProduct {
    @Override
    public void setting() {
        log.info("小米路由设置~~~~~~~~");
    }

    @Override
    public void open() {
        log.info("小米路由打开~~~~~~~");
    }
}
