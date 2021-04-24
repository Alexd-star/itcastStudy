package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
* 使用新的工具类
* */
public class Druid2 {
    public static void main(String[] args) {
        /*
        * 完成添加操作，给count表添加一条记录
        * */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into account values (null,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"张三");
            preparedStatement.setInt(2,1000);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement, connection);
        }
    }
}
