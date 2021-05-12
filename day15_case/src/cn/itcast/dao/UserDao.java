package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/*
 * �û�������Dao��
 * */
public interface UserDao {
    public List<User> findAll();

    User findUserByUsernameAndPassWord(String username, String password);

    void add(User user);

    void delete(int id);
}
