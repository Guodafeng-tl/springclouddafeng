package web.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 13:14 2022/5/22
 **/
@Slf4j
public class TestAbstractThree extends TestAbstractService {
    @Override
    public void doHandleAbstract() {
        log.info("trace log TestAbstractThree doHandleAbstract");
    }
}
