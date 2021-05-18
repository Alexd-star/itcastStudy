package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //ʹ��JDBC�������ݿ�
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassWord(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void add(User user) {
        //1.����sql
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.ִ��sql
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void delete(int id) {
        //1.����sql
        String sql = "delete from user where id = ?";
        //2.ִ��sql
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User findById(int id) {
        //1.����sql
        String sql = "select * from user where id = ?";
        //2.ִ��sql
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ? ,gender = ?,age = ?,address = ? ,qq = ?,email = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.����һ��ģ��sql
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {

            //�ų���ҳ��������
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if (value != null && !"".equals(value)) {
                //��ֵ
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//�Ӳ�����������ֵ
            }
        }
        sql = sb.toString();

        return jdbcTemplate.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";

        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condition.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {

            //�ų���ҳ��������
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //��ȡvalue
            String value = condition.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if (value != null && !"".equals(value)) {
                //��ֵ
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//�Ӳ�����������ֵ
            }
        }

        //��ӷ�ҳ��ѯ
        sb.append(" limit ?,? ");
        //��ӷ�ҳ��ѯ����ֵ
        params.add(start);
        params.add(rows);
        System.out.println(sql);
        System.out.println(params);

        sql = sb.toString();

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
