package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.TestService;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;

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


    @GetMapping("/readData")
    public void readData() throws Exception {
        FileInputStream fileInputStream=null;
        try {
            String url="D://test//test.txt";
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
    }
}
