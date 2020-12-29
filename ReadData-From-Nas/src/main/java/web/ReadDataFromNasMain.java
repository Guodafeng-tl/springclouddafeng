package web;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author : dafeng.guo
 * @date : 16:53 2020/12/17
 * exclude = {DataSourceAutoConfiguration.class}
 * 因为添加了数据库组件，所以autoconfig会去读取数据源配置，
 * 而新建的项目还没有配置数据源/URL地址错误，所以会导致异常出现。
 * 排除此类的autoconfig
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class ReadDataFromNasMain {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ReadDataFromNasMain.class,args);

        //Java -Durl="D:/test/test.txt" -jar name.jar
        /*String contents=System.getProperty("url");  //以jar启动获取参数传入的路径
        ToExcel(contents);*/
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
        hashMap.put("4","xxxxxxxxxx,yyyyyyyyyyyyyyyyy");
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
}
