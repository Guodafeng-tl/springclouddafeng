package web.abstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 16:35 2021/4/26
 **/
@Slf4j
public class AbstractFactoryMain {

    public static void main(String[] args) {
        log.info("**********************生产小米产品********************");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IPhoneProduct xiaomiPhoneProduct = xiaomiFactory.iPhoneProduct();
        IRouteProduct xiaomiRouteProduct = xiaomiFactory.iRouteProduct();
        xiaomiPhoneProduct.call();
        xiaomiPhoneProduct.sendMsg();
        xiaomiRouteProduct.open();
        xiaomiRouteProduct.setting();
        log.info("----------------------生产华为产品---------------------");
        HuaWeiFactory huaWeiFactory = new HuaWeiFactory();
        IPhoneProduct huaweiPhoneProduct = huaWeiFactory.iPhoneProduct();
        huaweiPhoneProduct.sendMsg();
        huaweiPhoneProduct.call();
        IRouteProduct huaweiRouteProduct = huaWeiFactory.iRouteProduct();
        huaweiRouteProduct.setting();
        huaweiPhoneProduct.call();
    }
}
