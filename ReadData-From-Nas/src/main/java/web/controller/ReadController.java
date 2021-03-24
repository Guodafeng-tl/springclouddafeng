package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.dao.Student;
import web.dao.Teacher;
import web.service.TestService;

import javax.annotation.Resource;
import java.io.*;

import org.apache.commons.io.FileUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : dafeng.guo
 * @date : 16:54 2020/12/17
 **/
@RestController
@Slf4j
public class ReadController {
    @Resource
    TestService testService;
    @GetMapping("/test")
    public String test(){
        return "helloC";
    }

    /**
     * 下层的异常会被捕捉
     * 直接输出在控制台
     * @ControllerAdvice注解类无法全局捕捉
     * @return
     */
    @GetMapping("/testTryCatch")
    public int testTryCatch() throws Exception{
        int i=0;
        try {
            // i = testService.resultTest();
            i = 1/0;
        }catch (Exception e){
            log.error("this  is testTryCatch***************"+String.valueOf(e));
        }
        return i;
    }
    /**
     * 下层的异常会被
     * @ControllerAdvice注解类全局捕捉
     * @return
     */
    @GetMapping("/testException")
    public int testException() throws Exception{
        log.info("this is testException ******************");
        //int  i = testService.resultTest();
        int i = 1/0;
        return i;
    }

    /**
     * 数据绑定
     * @param model
     */
    @GetMapping("/helloControllerAdviance")
    public void helloControllerAdviance(Model model) {
        Map<String, Object> map = model.asMap();
        log.info(map.get("md").toString());
    }

    /**
     * 读取文件内容
     * @throws Exception
     */
    /*@GetMapping("/readData")
    public void readData() throws Exception {
        FileInputStream fileInputStream=null;
        try {
            String url="D:/test/test.txt";
            File file = new File(url);
            if (!file.exists()){
                throw new Exception("您访问的文件不存在");
            }
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1){
                String info = new String(bytes, 0, len);
                log.info(info);
            }
        }catch (Exception e){
            log.error(String.valueOf(e));
        }finally {
            if (fileInputStream != null){
                fileInputStream.close();
            }
        }
    }*/

    /**
     * 遍历文件夹
     */
    @GetMapping("/selectContents")
    public void selectContents() throws Exception {
        java.lang.String contents="D:/test";
        File file = new File(contents);
        getContents(file);
    }

    /**
     * 遍历文件夹目录
     * @param file
     * @throws Exception
     */
    public void getContents(File file) throws Exception{
        if (!file.exists()){
            throw new Exception("Sorry,您访问的文件不存在！！！");
        }
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory()){
                getContents(f);
            }else{
                readFileInfo(f);
            }
        }
    }

    public void readFileInfo(File file) throws Exception{
        String name = file.getName();

        log.info(name+"文件内容如下");
        FileInputStream fis=null;
        try {
            fis=new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len ;
            while ((len = fis.read(bytes)) != -1){
                String info = new String(bytes, 0, len);
                log.info(info);
            }
            log.info(name+"文件内容读取结束======================================");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fis != null){
                fis.close();
            }
        }
    }

    @GetMapping("/testWriteMapToExcel")
    public void testWriteMapToExcel() throws IOException {
        String contents="D:/test";
        ToExcel(contents);
       /* Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sdf.format(currentDate));*/

    }

    private static void ToExcel(String pathUrl) throws IOException {

        //创建excel工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //定义表头
        String[] title = {"key","value"};
        //创建工作表
        XSSFSheet sheet = workbook.createSheet();
        //创建第一行表头
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = null;
        //插入第一行数据的表头
        for(int i = 0; i < title.length; i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("0","881,991");
        hashMap.put("1","882,992");
        hashMap.put("2","883,993");
        hashMap.put("3","883,994");
        for (int i=0;i<hashMap.size();i++){
            String s = hashMap.get(String.valueOf(i));
            String[] split = s.split(",");
            XSSFRow row1 = sheet.createRow(i+1);
            XSSFCell cell1 = row1.createCell(0);
            cell1.setCellValue(split[0]);
            XSSFCell cell2 = row1.createCell(1);
            cell2.setCellValue(split[1]);
        }
        
        //创建excel文件
        File file=new File(pathUrl+".xlsx");
        
        FileOutputStream stream=null;
        try {
            file.createNewFile();
            //将excel写入
            stream= FileUtils.openOutputStream(file);
            workbook.write(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stream != null){
                stream.close();
            }
        }


    }

    /**
     * 以key value形式获取文件内容
     */
    @GetMapping("/testProperties")
    public  void testProperties() throws Exception{

        Properties properties = new Properties();
        InputStream resourceAsStream = new FileInputStream("D:/test.txt");
        properties.load(resourceAsStream);
        Object key1 = properties.get("key1");
        System.out.println("9999999999");
    }

    /**
     * 测试 String.format
     */
    @GetMapping("/testStringFormat")
    public void testStringFormt(){
        String info="spdb.oss[%d].bucketList";
        String format = String.format(info, 6);
        System.out.println(format);
    }

    /**
     * ConcurrentHashMap测试
     */
    @GetMapping("/testConcurrentHashMap")
    public void testConcurrentHashMap(){
        ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<>();
        cmap.put("key1","value1");
        cmap.put("key2","value2");
        cmap.put("key2","value2");
        cmap.put("key2","value3");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key6","value6");
        hashMap.put("key6","value6");
        hashMap.put("key6","value");
        log.info("ConcurrentHashMap test-------------");
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

    @GetMapping("/hello1")
    public void hello1() throws IOException {
        ArrayList<Map<String,String>> list = new ArrayList<>();
        ArrayList<Map<String,String>> list2 = new ArrayList<>();

        Map<String,String> hashMap1 = new HashMap<>();
        hashMap1.put("name","111");
        hashMap1.put("total","1");
        Map<String,String> hashMap2 = new HashMap<>();
        hashMap2.put("name","222");
        hashMap2.put("total","2");
        Map<String,String> hashMap3 = new HashMap<>();
        hashMap3.put("name","333");
        hashMap3.put("total","3");
        list.add(hashMap1);
        list.add(hashMap2);
        list.add(hashMap3);
        Map<String,String> hashMap4 = new HashMap<>();
        hashMap4.put("name","111");
        hashMap4.put("total","2");
        hashMap4.put("key1","3");
        list2.add(hashMap4);
        for (Map<String,String> map : list){
            for (Map<String,String> map2 : list2){
                if (map.get("name").equals(map2.get("name"))){
                    map.putAll(map2);
                }
            }
        }
        for (Map<String,String> map : list){
            for (String key: map.keySet()){
                log.info("key"+key+".....value"+map.get(key));
            }
        }

    }

    @GetMapping("/copyBean")
    public void copyBean() throws IOException {
        Student student = new Student();
        student.setId("000000000");
        student.setName("wwww");
        student.setAge(1);
        //BeanUtils.copyProperties(a,b);   将a的属性赋值给b（ab的共同属性）
        Teacher teacher = new Teacher();
        //BeanUtils.copyProperties(student,teacher);
        teacher.setName("7777");
        log.info(teacher.getName());
        List<Teacher> objects = new ArrayList<>();
        objects.add(teacher);
        student.setList(objects);
        for (Teacher t : student.getList()){
            t.setName("999");
        }
        for (Teacher t : student.getList()){
            log.info(t.getName());
        }

    }

    @GetMapping("/testVersion")
    public void testVersion(){
        String a="2";
        String s = a.split("\\.")[0];
        log.info(s);
    }

    @GetMapping("/tetsFile")
    public void tetsFile(){
        File file = new File("dafeng.sh");
        log.info(String.valueOf(file.exists()));
    }

    @GetMapping("/testMonth")
    public int testMonth() throws ParseException {
        String s1 = "2021-05-01";
        String s2= "2020-12-01";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sf.parse(s1);
        Date d2 = sf.parse(s2);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        if(c1.getTimeInMillis() < c2.getTimeInMillis()) {
            return 0;
        }
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval --;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2 ;
        if(day1 < day2) {
            monthInterval --;
        }
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }

    @GetMapping("/longToStringDate")
    public void testTime() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse("2021-03-18 10:00:00");
        Date d2 = df.parse("2021-03-19 13:30:28");
        long cost = d2.getTime() - d1.getTime();
        String resultTime = costTimeLongToString(cost);
        log.info("毫秒数："+String.valueOf(cost)+";"+"转换成时分秒："+resultTime);
    }
    /**
     * 将long型转换成 Sting
     * @param cost
     * @return
     */
    public String costTimeLongToString(long cost){
        Date date = new Date();
        date.setTime(cost);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        //这里之所以减去8   因为时差
        int hour = instance.get(Calendar.HOUR) - 8;
        int miniute = instance.get(Calendar.MINUTE);
        int second = instance.get(Calendar.SECOND);
        int day = instance.get(Calendar.DAY_OF_MONTH);
        if (day > 1){
            hour = hour + (day - 1) * 24;
        }
        StringBuilder sb = new StringBuilder(String.format("%02d",hour));
        sb.append(":").append(String.format("%02d",miniute)).append(":").append(String.format("%02d",second));
        return sb.toString();
    }
}