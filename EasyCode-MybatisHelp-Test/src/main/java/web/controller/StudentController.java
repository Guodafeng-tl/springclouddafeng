package web.controller;

import cn.hutool.json.JSON;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import web.dao.test.StudentDao;
import web.entity.Student;
import lombok.extern.slf4j.Slf4j;
import web.entity.Teacher;
import web.service.StudentService;
import org.springframework.web.bind.annotation.*;
import web.service.TeacherService;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

    @GetMapping("/testInsertBigdecimal")
    public void testInsertBigdecimal() throws IOException {
        Teacher teacher = new Teacher();
        teacher.setName("DAfeng001");
        teacher.setPercent(new BigDecimal("1000.123"));
        teacher.setAge(1);
        teacher.setId(2);

        Teacher teacher1 = new Teacher();
        teacher1.setName("DAfeng002");
        teacher1.setPercent(new BigDecimal("999.123"));
        teacher1.setAge(2);
        teacher1.setId(3);
        teacherService.insert(teacher1);

        teacherService.insert(teacher);

    }
    public static void main(String[] args) throws Exception{
        //1、获取原始sql输入
        String sql = "select id, name from test.student where id = ? #我们";
        System.out.println("old sql:[{}]"+sql);
        Pattern p = Pattern.compile("(?ms)('(?:''|[^'])*')|--.*?$|//.*?$|/\\*.*?\\*/|#.*?$|");
        String presult = p.matcher(sql).replaceAll("$1");
        System.out.println(presult);
        //2、创建解析器
        CCJSqlParserManager mgr = new CCJSqlParserManager();
        //3、使用解析器解析sql生成具有层次结构的java类
        Statement stmt = mgr.parse(new StringReader(sql));
        //5、打印转换后的sql语句
        System.out.println("new sql:[{}]" + stmt.toString());
    }

    @PostMapping(value = "/excel")
    public String importExcel(@RequestParam("file") MultipartFile excel) throws IOException {
        Workbook workbook = new HSSFWorkbook(excel.getInputStream());
        return null;
    }

}