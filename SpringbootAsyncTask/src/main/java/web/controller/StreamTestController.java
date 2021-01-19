package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : dafeng.guo
 * @date : 10:40 2021/1/4
 **/
@RestController
@Slf4j
public class StreamTestController {

    /**
     *  stream流转换集合新特性
     *  list转换成MAP
     */
    @GetMapping("/streamToMap")
    public void streamToMap(){
        List<Person> list = new ArrayList();
        list.add(new Person("1001", "小A"));
        list.add(new Person("1002", "小B"));
        list.add(new Person("1003", "小C"));

        Map<String, String> collect = list.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));

        for (String key : collect.keySet()){
            log.info(key);
            log.info(collect.get(key));
        }
        log.info("========================================================");
        Map<String, String> collect1 = list.stream().filter(x -> !x.getId().equals("1001"))
                .collect(Collectors.toMap(Person::getId, Person::getName));
        collect1.forEach((k,v) -> log.info(k+","+v));
        log.info("=========================================================999");
        list.stream().map(person -> person)
                .forEach(person -> log.info(person.getId()+","+person.getName()));
    }

    /**
     * map集合通过流转换成list
     * forEach简单测试
     */
    @GetMapping("/streamToList")
    public void streamToList(){
        Map<String,String> map=new HashMap<>();
        map.put("1","AAAA");
        map.put("2","BBBB");
        map.put("3","CCCC");
        map.put("4","DDDD");
        map.put("5","EEEE");
        List<Object> list= map.entrySet().stream().map(et ->et.getKey()+"_"+et.getValue()).collect(Collectors.toList());
        list.forEach(o -> log.info(o.toString()));
        log.info("==============================================");
        List<String> collect = map.keySet().stream().collect(Collectors.toList());
        collect.forEach(s -> log.info(s));
        log.info("==============================================");
        map.forEach((k, v) -> log.info(k+","+v));
    }

    /**
     *@RequestBody  测试
     */

    @PostMapping("/testRequestMap")
    public void testMap(@RequestBody Map<String,String> map){
        for (String s : map.keySet()){
            log.info(s);
        }
    }

    @PostMapping("/testRequestParam")
    public void testRespBody(@RequestParam(value = "plugiName",required = false) String plugiName){
       log.info(plugiName);
       log.info("00000000000000");
    }
}
