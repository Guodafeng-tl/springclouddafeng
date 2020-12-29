package s3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import s3.inter.OSSService;

import javax.annotation.Resource;

/**
 * @author : dafeng.guo
 * @date : 16:20 2020/12/29
 **/
@RestController
public class testControler {

    @GetMapping("/testOSS")
    public void testOSS(){
        System.out.printf("ossService");
    }
}
