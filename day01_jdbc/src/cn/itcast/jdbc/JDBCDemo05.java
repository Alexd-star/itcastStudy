package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JDBCUtil;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

/*
* 需求：
*   1.通过键盘录入用户名和密码
*   2.判断用户是否登录成功
* */
public class JDBCDemo05 {
    public static void main(String[] args) {
        //键盘输入，接收用户名和密码
        Scanner scanner =new Scanner(System.in);
        System.out.print("请输入用户名:");
        String username = scanner.next();
        System.out.print("密码:");
        String password = scanner.next();
        //调用方法
        if (login2(username,password)){
            System.out.println("\n登录成功！");
        }else {
            System.out.println("\n用户名或密码错误！登录失败！");
        }

        //判断结果，输出不同值
    }

    /*
    使用执行sql的对象prepareStatement
    防止sql注入，效率更高
    */

    public static boolean login2(String username, String password){
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        if (username == null || username == null){
            return false;
        }
        try {
            //获取连接
            connection = JDBCUtil.getConnection();
            //定义查询语句
            String sql = "select * from user where username = ? and password = ?";
            //创建执行sql的对象
            preparedStatement = connection.prepareStatement(sql);
            //给?赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //执行sql
            resultSet = preparedStatement.executeQuery();
            //判断
            /*if (resultSet.next()){//如果有下一行，表示已经查到
                return true;
            }else {
                return false;
            }*/
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return false;
    }


    /*
    * 会产生sql注入的安全问题
    * */

    public static boolean login(String username, String password){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        if (username == null || username == null){
            return false;
        }
        try {
            //获取连接
            connection = JDBCUtil.getConnection();
            //定义查询语句
            String sql = "select * from user where username = '"+username+"'and password = '"+password+"'";
            //创建执行sql的对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery(sql);
            //判断
            /*if (resultSet.next()){//如果有下一行，表示已经查到
                return true;
            }else {
                return false;
            }*/
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet, statement, connection);
        }
        return false;
    }
}
