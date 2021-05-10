package web.abstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 15:04 2021/4/26
 **/
@Slf4j
public class HuaweiIRoute implements IRouteProduct {
    @Override
    public void setting() {
        log.info("华为路由设置~~~~");
    }

    @Override
    public void open() {
        log.info("华为路由打开~~~");
    }
}
