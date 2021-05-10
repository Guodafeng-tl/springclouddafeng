package web.abstractFactory;

/**
 * @author : dafeng.guo
 * @date : 16:30 2021/4/26
 **/
public class HuaWeiFactory implements IProductFactory {
    @Override
    public IPhoneProduct iPhoneProduct() {
        return new HuaWeiIPhone();
    }
    @Override
    public IRouteProduct iRouteProduct() {
        return new HuaweiIRoute();
    }
}
