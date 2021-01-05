package s3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * @author : dafeng.guo
 * @date : 16:20 2020/12/29
 **/
@RestController
@Slf4j
public class testControler {
    /**
     *测试时间格式
     */
    @GetMapping("/testDate")
    public void testDate1() throws Exception{
        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        // 2020年12月26日周六
        c.set(Calendar.DATE, 26);
        log.info("YYYY-MM-dd = " + df1.format(c.getTime()));
        log.info("yyyy-MM-dd = " + df2.format(c.getTime()));

        log.info("========================");
        // 2020年12月27日 周日
        c.add(Calendar.DATE, 1);
        log.info("YYYY-MM-dd = " + df1.format(c.getTime()));
        log.info("yyyy-MM-dd = " + df2.format(c.getTime()));
    }
}
