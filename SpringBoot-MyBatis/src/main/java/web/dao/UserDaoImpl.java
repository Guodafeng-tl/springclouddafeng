package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entity.User;

/**
 * @author : dafeng.guo
 * @date : 16:57 2021/9/15
 **/
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    UserDao userDao;
    @Override
    public void update(User user) {
        userDao.update(user);
        System.out.printf("修改成功");
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
}
