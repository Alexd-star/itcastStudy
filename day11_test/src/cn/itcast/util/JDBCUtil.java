package cn.itcast.util;

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
public class JDBCUtil {
    private static DataSource dataSource;

    static {
        //1.加载配置文件
        Properties properties = new Properties();
        //使用ClassLoader加载配置文件，获取字节输入流
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            properties.load(resourceAsStream);

            //2.初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
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

    public static void close(Statement statement, Connection connection) {

        close(null, statement, connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
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
    public static DataSource getDataSource() {
        return dataSource;
    }
}
