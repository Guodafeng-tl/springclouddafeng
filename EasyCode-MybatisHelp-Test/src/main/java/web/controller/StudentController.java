package web.controller;

import cn.hutool.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import web.dao.test.StudentDao;
import web.entity.Student;
import lombok.extern.slf4j.Slf4j;
import web.entity.Teacher;
import web.service.StudentService;
import org.springframework.web.bind.annotation.*;
import web.service.TeacherService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Student)表控制层
 *
 * @author dafeng.guo
 * @since 2020-12-09 14:56:22
 */
@RestController
@Slf4j
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    public String selectOne(@PathVariable Integer id) throws IOException {
        Student student = studentService.queryById(id);
        Teacher teacher = teacherService.queryById(id);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(student.toString()).append(teacher.toString());
        return stringBuffer.toString();
    }

    @GetMapping("/hello")
    public void hello() throws IOException {
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("key1","value1");
        hashMap.put("key1","value2");
        hashMap.put("key1","value3");
        for (String value : hashMap.values()){
            log.info(value);
        }
    }

    @GetMapping("/cache/{name}")
    public List<Student> cacheTest(@PathVariable String name) throws IOException {
        log.info("测试缓存开始");
        List<Student> result = (List<Student>)GoogleCacheTest.get(name, () -> studentService.queryAll(Student.builder().name(name).build()));
        log.info("查询的接口：{}",result);
        return result;
    }
}