package web.dao;

import web.entity.User;

import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 15:24 2021/5/17
 **/
public interface UserDao {

    List<User> getUserList() throws Exception;
}
