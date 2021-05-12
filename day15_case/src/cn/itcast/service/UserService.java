package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

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
}
