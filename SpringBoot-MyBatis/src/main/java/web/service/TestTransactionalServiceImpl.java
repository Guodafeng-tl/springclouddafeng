package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.entity.User;

/**
 * @author : dafeng.guo
 * @date : 16:52 2021/9/15
 **/
@Service
public class TestTransactionalServiceImpl implements TestTransactionalService {

    @Autowired
    private UserDao userDao;
    @Override
    public void update(User user) {
        this.insert(user);
        int i=1/0;
    }

    @Override
    @Transactional
    public void insert(User user) {
        userDao.insert(user);
    }
}
