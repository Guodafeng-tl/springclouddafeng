package web.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.entity.Student;
import web.entity.Test;
import web.service.MongoService;

import java.util.*;

/**
 * @author : dafeng.guo
 * @date : 10:47 2021/1/5
 **/
@RestController
@Slf4j
public class MongoTestController {

    @Autowired
    MongoService mongoService;

    /**
     * 保存数据到mongodb
     * @return
     */
    @GetMapping("/testSave")
    public String testSave(){
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("wwwwwww");
        student.setAge(100);
        mongoService.saveInfo(student);
        return "插入成功~~~";
    }
    @GetMapping("/findAllInfo")
    public List<Student> findAllInfo(){
        List<Student> all = mongoService.findAll();
        all.forEach(info -> log.info(info.getName()));
        return all;
    }


    @GetMapping("/findInfo")
    public List<Student> findInfo(){
        List<Student> all = mongoService.findAll();
        all.forEach(info -> log.info(info.getName()));
        Student student = new Student();
        student.setId("0de847a7-84e1-4a06-8c7e-b28202c6f071");
        List<Student> studentById = mongoService.findStudentById(student);
        return studentById;
    }

    @GetMapping("/updateInfo")
    public String updateInfo(){
        Student student = new Student();
        student.setId("0de847a7-84e1-4a06-8c7e-b28202c6f071");
        student.setName("xxxxxxx");
        student.setAge(200);
        mongoService.updateStudent(student);
        return "更新成功~";
    }

    @GetMapping("/deleteInfo")
    public String deleteStudent() {
        Student student = new Student();
        student.setId("9aced04a-fa6f-4fe6-b5ec-70d4790e063c");
        mongoService.removeStudent(student);
        return "删除成功~~~";
    }

    @GetMapping("/testSavePart")
    public String testSavePart(){
        List<String> strings = new ArrayList<>();
        strings.add("111");
        strings.add("222");
        Map<String, List<String>> hashMap = new HashMap<>();
        hashMap.put("aaa",strings);
        Map<String, List<String>> hashMap2 = new HashMap<>();
        hashMap2.put("bbb",strings);
        Test test = new Test();
        List<Map<String,List<String>>> list = new ArrayList<>();
        list.add(hashMap);
        list.add(hashMap2);
        test.setPart(list);
        mongoService.saveTest(test);
        return "插入成功a~~~";
    }

    @GetMapping("/testMap")
    public void testMap(){
        
        HashMap<String, Boolean> result = new HashMap<>();
        result.put("status",false);
        result.put("status",true);
        log.info("0000");

        ArrayList<Student> students = new ArrayList<>();
        int size = students.size();
        log.info(String.valueOf(students.size()));
    }
}
