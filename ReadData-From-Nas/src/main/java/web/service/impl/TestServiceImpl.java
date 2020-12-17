package web.service.impl;

import org.springframework.stereotype.Service;
import web.service.TestService;

/**
 * @author : dafeng.guo
 * @date : 17:42 2020/12/17
 **/
@Service
public class TestServiceImpl implements TestService {
    @Override
    public int resultTest() throws Exception {
        return 1/0;
    }
}
