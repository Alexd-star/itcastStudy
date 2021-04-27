package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        return null;
    }
}
