package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid {
    public static void main(String[] args) throws Exception {
        /*//1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);*/

        /*//获取连接
        Connection connection = dataSource.getConnection();*/
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);

        JDBCUtils.close(null,connection);
    }
}
