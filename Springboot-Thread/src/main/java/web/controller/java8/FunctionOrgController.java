package web.controller.java8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : dafeng.guo
 * @date : 18:01 2022/7/12
 **/
@Slf4j
@RestController
public class FunctionOrgController {

    public static void main(String[] args) {
        System.out.println("案例一字符串成大写");
        Function<String,String> function = str->{
            return str.toUpperCase();
        };

        String resultApply = function.apply("hhhda");
        System.out.println(resultApply);

        System.out.println("案例二字符串长度");
        Function<String, Integer> resultIn = s -> s.length();
        Integer applyInteger = resultIn.apply("wwwww");
        System.out.println(applyInteger);

        System.out.println("案例三使用andThen");
        Function<String, Integer> lengthFunction = str -> str.length();
        Function<Integer, Integer> doubleFunction = length -> length * 2;
        Integer doubleLength = lengthFunction.andThen(doubleFunction).apply("www.wdbyte.com");
        System.out.println(doubleLength);

        System.out.println("案例四list2map并设置元素长度");

        List<String> list = Arrays.asList("java", "nodejs", "wdbyte.com");
        // lambda 方式
        Function<String, Integer> length2Function = str -> str.length();
        Map<String, Integer> listToMap = listToMap(list, length2Function);
        System.out.println(listToMap);

        // 方法引用方式
        Map<String, Integer> listToMap2 = listToMap(list, String::length);
        System.out.println(listToMap2);

        List<String> list2 = Arrays.asList("Java", "Nodejs", "Wdbyte.com","go");
        // 方法引用方式
        List<String> upperList = map(list2, String::toUpperCase);
        List<String> lowerList = map(list2, String::toLowerCase);
        System.out.println(upperList);
        System.out.println(lowerList);

        // Lambda 方式
        List<String> upperList2 = map(list, x -> x.toUpperCase());
        List<String> lowerList2 = map(list, x -> x.toLowerCase());
        System.out.println(upperList2);
        System.out.println(lowerList2);
        System.out.println("案例五");
        Function<String, String> strStream = str -> str+"666";
        List<String> collect = list2.stream().map(strStream).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * list转map并将值设置为  元素长度
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Map<T, R> listToMap(List<T> list, Function<T, R> function) {
        HashMap<T, R> hashMap = new HashMap<>();
        for (T t : list) {
            hashMap.put(t, function.apply(t));
        }
        return hashMap;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> resultList = new ArrayList<>(list.size());
        for (T t : list) {
            resultList.add(function.apply(t));
        }
        return resultList;
    }

}
