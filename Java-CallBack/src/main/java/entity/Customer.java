package entity;

import callbackInterface.CallBckInterface;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 14:18 2021/11/2
 **/
@Slf4j
@Builder
public class Customer implements CallBckInterface {
    //持有酒店的引用
    private Hotel hotel;

    public Customer(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * 客户等待被叫醒
     */
    @Override
    public void waitWakedUp() {
        log.info("***********时间到了，客户被预约的酒店管家叫醒***********");
    }

    /**
     * 酒店管家到时间叫醒顾客
     */
    public void bookWakeUp(){
        hotel.wakeup(this);
    }
}
