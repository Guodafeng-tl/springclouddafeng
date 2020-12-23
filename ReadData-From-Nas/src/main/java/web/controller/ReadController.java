package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.TestService;

import javax.annotation.Resource;
import java.io.*;

import org.apache.commons.io.FileUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
             i = testService.resultTest();
        }catch (Exception e){
            log.error(String.valueOf(e));
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
        int  i = testService.resultTest();
        return i;
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
}