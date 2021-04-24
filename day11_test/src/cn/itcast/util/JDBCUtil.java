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
 * Druid���ݿ����ӳع�����
 * */
public class JDBCUtil {
    private static DataSource dataSource;

    static {
        //1.���������ļ�
        Properties properties = new Properties();
        //ʹ��ClassLoader���������ļ�����ȡ�ֽ�������
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            properties.load(resourceAsStream);

            //2.��ʼ�����ӳض���
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * ��ȡ����
     * */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /*
     * �ͷ���Դ
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
                connection.close();//�黹����
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
     * ��ȡ���ݿ����ӳ�
     * */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
