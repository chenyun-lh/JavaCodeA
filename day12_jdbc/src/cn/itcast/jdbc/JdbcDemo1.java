package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {

        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false", "root", "abc123");
        //4.定义sql语句
        String sql = "update account set balance = 1000 where id = 1";
//        String sql = "update account set balance = 2000";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();

    }
}
//jdk1.8 连接驱动5.1.26 mysql5.7 可以
//jdk1.8 连接驱动5.1.26 mysql8.x 不行
//jdk1.8 连接驱动8.0.12 mysql5.7 可以
//jdk1.8 连接驱动8.0.12 mysql8.x 可以
//jdk11 连接驱动5.1.26 mysql5.7 可以
//jdk11 连接驱动5.1.26 mysql8.x 不行
//jdk11 连接驱动8.0.12 mysql5.7 可以
//jdk11 连接驱动8.0.12 mysql8.x 可以

//?serverTimezone=GMT%2B8 ?serverTimezone=UTC
//mysql设置时区命令
//show variables like '%time_zone%';
//set global time_zone='+8:00';