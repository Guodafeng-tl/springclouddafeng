package web.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 16:13 2022/4/27
 **/
@Slf4j
public class TestAbstractSecond extends TestAbstractService {

    @Override
    public void doHandleAbstract() {
        log.info("trace log TestAbstractSecond doHandleAbstract");
    }
}

