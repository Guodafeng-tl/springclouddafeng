package web.controller.java8;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : dafeng.guo
 * @date : 22:37 2022/7/12
 **/
public class SupplierTest {
    public static void main(String[] args) {
        Car car = Car.supplier.get();
        System.out.println(car);
        Supplier<Integer> supplier = ()->RandomNumber.getNext();
        List<Integer> collect = Stream.generate(supplier).limit(5).filter(number -> number > 5).collect(Collectors.toList());
        System.out.println(collect);
    }


}
class RandomNumber{
        private static  Random random= new Random();
        public static Integer getNext(){
            return random.nextInt(10);
        }
}