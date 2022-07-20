package web.controller.java8;

import lombok.Data;
import lombok.ToString;

import java.util.function.Supplier;

/**
 * @author : dafeng.guo
 * @date : 22:38 2022/7/12
 **/
@Data
public class Car {
    private static  String color="red";
    private static  double price=1000000;
    public static  Supplier<Car> supplier = ()->new Car();

    @Override
    public String toString() {
        return "car{color:"+color+";price:"+price+"}";
    }
}
