package web.controller.java8;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : dafeng.guo
 * @date : 22:10 2022/7/12
 **/
@RestController
public class PredicateOrgController {
    public static void main(String[] args) {
        Predicate<String> predicate = str->str.length()> 3;
        boolean ww = predicate.test("Ww");
        System.out.println("案例一");
        System.out.println(ww);
        List<String> list = Arrays.asList("java", "nodejs", "wdbyte.com","go","python");
        List<String> result = list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println("案例二");
        System.out.println(result);

        boolean present = Optional.ofNullable(null).isPresent();
        System.out.println(present);

    }
}
