package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/*
 * 用户操作的Dao层
 * */
public interface UserDao {
    public List<User> findAll();

    User findUserByUsernameAndPassWord(String username, String password);

    void add(User user);

    void delete(int id);

    User findById(int id);

    void update(User user);

    /**
     * 查询总记录
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每条记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
