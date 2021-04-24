package cn.itcast.jdbc;

import java.sql.*;

/**
 * 执行DDL语句
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///luocheng", "root", "123");
            //3.定义sql
            String sql  = "select 姓名,籍贯,电话 from students";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.处理结果
            while (rs.next()){
                    //判断是否有数据
                    //6.2 获取数据
                    String name = rs.getString(1);
                    String prv = rs.getString("籍贯");
                    long phone = rs.getLong(3);

                    System.out.println(name + "---" + prv + "---" + phone);
            }




           /* //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            String name = rs.getString(1);
            String prv = rs.getString("籍贯");
            long phone = rs.getLong(3);

            System.out.println(name + "---" + prv + "---" + phone);


            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            String name1 = rs.getString(1);
            String prv1 = rs.getString("籍贯");
            long phone1 = rs.getLong(3);

            System.out.println(name1 + "---" + prv1 + "---" + phone1);

            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            String name2 = rs.getString(1);
            String prv2 = rs.getString("籍贯");
            long phone2 = rs.getLong(3);

            System.out.println(name2 + "---" + prv2 + "---" + phone2);*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源

            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
