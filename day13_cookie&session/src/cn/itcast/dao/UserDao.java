package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * 操作数据库中User的类
 * */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    /**
     * 登录方法
     *
     * @param loginUser 用户的用户名和密码
     * @return user包含用户的全部数据，如果没有查询到，返回null值
     */
    public User login(User loginUser) {

        try {
            //1.编写sql语句
            String sql = "select * from user where name=? && password=?";

            User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),loginUser.getName(),loginUser.getPassword());

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
