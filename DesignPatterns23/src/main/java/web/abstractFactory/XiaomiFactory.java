package web.abstractFactory;

/**
 * @author : dafeng.guo
 * @date : 15:17 2021/4/26
 **/
public class XiaomiFactory implements IProductFactory {
    @Override
    public IPhoneProduct iPhoneProduct() {
        return new XiaomiIPhone();
    }
    @Override
    public IRouteProduct iRouteProduct() {
        return new XiaomiIRoute();
    }
}
