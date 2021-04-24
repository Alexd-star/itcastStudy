package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo06 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement  = null;
        PreparedStatement preparedStatement1 = null;
        try {
            //获取连接
            connection = JDBCUtil.getConnection();

            //开启事物
            connection.setAutoCommit(false);

            //定义sql
            String sql = "update user set password = password - ? where id = ?";
            String sql2 = "update user set password = password + ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement1 = connection.prepareStatement(sql2);
            //设置?参数
            preparedStatement.setDouble(1,100);
            preparedStatement.setInt(2,1);
            preparedStatement1.setDouble(1,100);
            preparedStatement1.setInt(2,2);

            //执行sql
            preparedStatement.executeUpdate();

            //制造异常
            int i = 3/0;
            preparedStatement1.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
           try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement,connection);
            JDBCUtil.close(preparedStatement1,null);
        }
    }
}
