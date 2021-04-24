package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * �������ݿ���User����
 * */
public class UserDao {

    //����JDBCTemplate������
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    /**
     * ��¼����
     *
     * @param loginUser �û����û���������
     * @return user�����û���ȫ�����ݣ����û�в�ѯ��������nullֵ
     */
    public User login(User loginUser) {

        try {
            //1.��дsql���
            String sql = "select * from user where name=? && password=?";

            User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),loginUser.getName(),loginUser.getPassword());

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
