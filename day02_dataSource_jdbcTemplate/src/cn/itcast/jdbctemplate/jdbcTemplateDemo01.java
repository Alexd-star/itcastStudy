package cn.itcast.jdbctemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
/*
* JdbcTemplate入门
*
* */
public class jdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql,1);
        System.out.println(count);
    }
}
