package web.abstractFactory;

/**
 * @author : dafeng.guo
 * @date : 15:15 2021/4/26
 **/
public interface IProductFactory {
    //生产手机
    IPhoneProduct iPhoneProduct();
    //生产路由
    IRouteProduct iRouteProduct();
}
