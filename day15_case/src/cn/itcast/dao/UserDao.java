package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/*
* �û�������Dao��
* */
public interface UserDao {
    public List<User> findAll();
}
