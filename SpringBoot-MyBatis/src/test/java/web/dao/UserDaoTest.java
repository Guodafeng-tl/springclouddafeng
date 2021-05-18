package web.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import web.entity.User;
import web.util.MyBatisSqlSessionFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : dafeng.guo
 * @date : 17:02 2021/5/18
 **/
class UserDaoTest {

    @Test
    void getUserList() throws Exception {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user:userList){
            System.out.println(user);
        }
    }
}