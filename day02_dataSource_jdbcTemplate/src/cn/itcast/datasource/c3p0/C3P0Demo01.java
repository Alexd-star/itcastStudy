package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
* C3P0的演示
* */
public class C3P0Demo01 {
    public static void main(String[] args) throws SQLException {
        /*//1.创建数据库连接对象
        DataSource ds = new ComboPooledDataSource();

        for (int i = 0; i < 10; i++) {
            //2.获取连接对象
            Connection connection = ds.getConnection();

            //3.打印
            System.out.println(connection); //com.mchange.v2.c3p0.impl.NewProxyConnection@72a7c7e0 [wrapping: com.mysql.jdbc.JDBC4Connection@2e4b8173]

        }*/

        testNameConfig();
    }

    public static void testNameConfig() throws SQLException {
        //1.创建数据库连接对象
        DataSource ds = new ComboPooledDataSource("otherc3p0");

        for (int i = 0; i < 10; i++) {
            //2.获取连接对象
            Connection connection = ds.getConnection();

            //3.打印
            System.out.println(connection); //com.mchange.v2.c3p0.impl.NewProxyConnection@72a7c7e0 [wrapping: com.mysql.jdbc.JDBC4Connection@2e4b8173]

        }
    }
}
