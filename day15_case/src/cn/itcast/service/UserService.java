package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/*
* �û������ҵ��ӿ�
* */
public interface UserService {
    /**
     * ��ѯ�����û���Ϣ
     * @return
     */
    public List<User> findAll();
}
