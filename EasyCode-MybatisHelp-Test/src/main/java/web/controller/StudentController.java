package web.controller;

import web.entity.Student;
import lombok.extern.slf4j.Slf4j;
import web.entity.Teacher;
import web.service.StudentService;
import org.springframework.web.bind.annotation.*;
import web.service.TeacherService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
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
    @GetMapping("/selectOne")
    public String selectOne(Integer id) throws IOException {
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
}