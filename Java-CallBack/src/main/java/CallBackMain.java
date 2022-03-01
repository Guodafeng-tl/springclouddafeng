import entity.Customer;
import entity.Hotel;
import entity.Test;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 14:01 2021/11/2
 **/
@Slf4j
public class CallBackMain {
    public static void main(String[] args) {
        /*回调测试
        Hotel hotel = Hotel.builder().build();
        Customer customer = Customer.builder().hotel(hotel).build();
        customer.bookWakeUp();*/

        Test test = Test.builder().id(1).name("aaaa").build();
        System.out.println("前"+test.getName());
        testMethod(test);
        System.out.println(test.getName());
    }

    public static String testMethod(Test test){
        test.setName("bbb");
        return "success";
    }

}
