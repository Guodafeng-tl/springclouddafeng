package web.service;

import web.entity.User;

/**
 * @author : dafeng.guo
 * @date : 16:51 2021/9/15
 **/
public interface TestTransactionalService {
    void update(User user);
    void insert(User user);
}
