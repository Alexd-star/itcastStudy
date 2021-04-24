package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("123");

        UserDao userDao = new UserDao();
        User login = userDao.login(user);

        System.out.println(login);
    }
}
