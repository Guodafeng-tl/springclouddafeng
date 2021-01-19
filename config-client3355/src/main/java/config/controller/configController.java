package config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : dafeng.guo
 * @date : 15:19 2021/1/14
 **/

@RestController
@RefreshScope
public class configController {
    @Value("${config.info}")
    private String  configInfo;

    @GetMapping("/getConfigInfo")
    public String getInfo(){
        return  configInfo;
    }
}
