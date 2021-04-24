package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* 定义一个方法，查询emp的数据将其封装成对象，然后装载集合，返回
* */
public class JDBCDemo04 {
    /*
     * 查询所有emp对象
     * @return
     * */

    public static void main(String[] args) {
        List<Emp> list = new JDBCDemo04().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }


    public List<Emp> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Emp> list = null;
        try {
            /*//1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.连接驱动
            connection = DriverManager.getConnection("jdbc:mysql:///luocheng", "root", "123");*/
            connection = JDBCUtil.getConnection();
            //3.定义sql
            String sql = "select * from emp";
            //4.执行sql的对象
            statement = connection.createStatement();
            //5.执行sql
            resultSet = statement.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (resultSet.next()) {
                //获取数据
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                double sal = resultSet.getDouble("sal");
                double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                //设置emp对象
                emp = new Emp();
                emp.setEmpno(empno);
                emp.setEname(ename);
                emp.setJob(job);
                emp.setMgr(mgr);
                emp.setHiredate(hiredate);
                emp.setSal(sal);
                emp.setComm(comm);
                emp.setDeptno(deptno);

                //装载集合
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*if (resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
            JDBCUtil.close(resultSet, statement, connection);
            return list;
        }
    }
}
