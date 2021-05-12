package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/*
 * 用户管理的业务接口
 * */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 登录方法
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 保存User对象
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除User
     *
     * @param id
     */
    void deleteUser(String id);
}
