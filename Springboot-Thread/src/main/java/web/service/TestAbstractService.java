package web.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 16:08 2022/4/27
 **/
@Slf4j
public abstract class TestAbstractService {


    public void doHandleAbstract(){
        log.info("trace log TestAbstractService doHandleAbstract");
    }
}
