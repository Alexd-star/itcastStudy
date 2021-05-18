package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/*
 * �û������ҵ��ӿ�
 * */
public interface UserService {
    /**
     * ��ѯ�����û���Ϣ
     *
     * @return
     */
    public List<User> findAll();

    /**
     * ��¼����
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * ����User����
     *
     * @param user
     */
    void addUser(User user);

    /**
     * ����idɾ��User
     *
     * @param id
     */
    void deleteUser(String id);

    /**
     * ����id��ѯ
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * �޸��û���Ϣ
     * @param user
     */
    void updateUser(User user);

    /**
     * ����ɾ���û�
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * ��ҳ������ѯ
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
