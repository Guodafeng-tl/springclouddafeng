package web.abstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 14:57 2021/4/26
 **/
@Slf4j
public class HuaWeiIPhone implements IPhoneProduct{
    @Override
    public void call() {
        log.info("华为手机进行呼叫~~~");
    }

    @Override
    public void sendMsg() {
        log.info("华为手机进行短信发送~~~");
    }
}
