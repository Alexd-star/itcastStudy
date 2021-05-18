package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/*
 * �û�������Dao��
 * */
public interface UserDao {
    public List<User> findAll();

    User findUserByUsernameAndPassWord(String username, String password);

    void add(User user);

    void delete(int id);

    User findById(int id);

    void update(User user);

    /**
     * ��ѯ�ܼ�¼
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * ��ҳ��ѯÿ����¼
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
