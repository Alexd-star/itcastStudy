package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/*
 * 用户操作的Dao层
 * */
public interface UserDao {
    public List<User> findAll();

    User findUserByUsernameAndPassWord(String username, String password);

    void add(User user);

    void delete(int id);
}
