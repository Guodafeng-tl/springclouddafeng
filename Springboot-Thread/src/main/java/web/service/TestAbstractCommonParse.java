package web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 16:10 2022/4/27
 **/
@Slf4j
public class TestAbstractCommonParse extends TestAbstractService {

    /**
     * 用来存储 其他bean
     */
    private  static final  List<TestAbstractService> testAbstractServiceList = new ArrayList<>();

    public void addTestAbstractService(TestAbstractService testAbstractService){
        testAbstractServiceList.add(testAbstractService);
    }

    @Override
    public void doHandleAbstract(){
        log.info("trace log TestAbstractCommonParse doHandleAbstract");
        for (TestAbstractService testAbstractService : testAbstractServiceList) {
            testAbstractService.doHandleAbstract();
        }
    }
}
