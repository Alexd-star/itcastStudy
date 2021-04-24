package cn.itcast.utils;

import cn.itcast.datasource.druid.Druid;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
* Druid数据库连接池工具类
* */
public class JDBCUtils {
    private static DataSource dataSource ;
    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.获取连接池对象
        try {
           dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 获取连接
    * */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /*
    * 释放资源
    * */

    public static void close(Statement statement,Connection connection){
        /*if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection!=null){
            try {
                connection.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

        close(null,statement,connection);
    }

    public static void close(ResultSet resultSet,Statement statement, Connection connection){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection!=null){
            try {
                connection.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 获取数据库连接池
    * */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
