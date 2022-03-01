package entity;

import callbackInterface.CallBckInterface;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 14:12 2021/11/2
 **/
@Slf4j
@Builder
public class Hotel {

    public void wakeup(CallBckInterface callBckInterface){
        log.info("**********客户预约了酒店管家的叫醒服务*****************");
        try {
            //模拟等待的时间
            Thread.sleep(3000);
            //时间过去了一夜
            log.info("************模拟时间过去了一夜,酒店管家开始去叫醒顾客************");
            callBckInterface.waitWakedUp();
            log.info("************模拟时间过去了一夜,酒店管家完成叫醒顾客************");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
