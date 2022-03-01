package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import web.entity.Apple;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : dafeng.guo
 * @date : 9:41 2021/5/17
 **/
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
    //看看就行  别启动了
@SpringBootApplication
public class MyBatisMain {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisMain.class, args);
    }
    /*public static void main(String[] args) {
        //SpringApplication.run(MyBatisMain.class, args);
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("1.25"),10,"CLAUSE");
        Apple apple12 = new Apple(2,"苹果2",new BigDecimal("2.35"),20,"CLAUSE");
        Apple apple13 = new Apple(3,"苹果3",new BigDecimal("3.35"),30,"TEMPLATE");
        Apple apple2 =  new Apple(4,"香蕉",new BigDecimal("2.89"),30,"TEMPLATE");
        Apple apple3 =  new Apple(5,"荔枝",new BigDecimal("9.99"),40,"TEMPLATE");

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        *//*Set<Apple> filterList = appleList.stream().filter(a -> Objects.nonNull(a.getType())).collect(Collectors.toSet());

        System.err.println("filterList:"+filterList);*//*
        *//*Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));
        System.out.println(appleMap);*//*

        Map<String, Apple> appleMap1 = appleList.stream().collect(Collectors.toMap(Apple::getType, Function.identity(),(key1, key2) -> key2));
        System.out.println(appleMap1);

        //List 以ID分组 Map<Integer,List<Apple>>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        groupBy.forEach((k,v)->{
            Map<String, List<Apple>> collect = v.stream().collect(Collectors.groupingBy(Apple::getType));
            System.out.println(collect);
        });
        System.err.println("groupBy:"+groupBy);


    }*/
}
