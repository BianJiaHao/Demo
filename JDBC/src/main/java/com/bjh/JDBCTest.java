package com.bjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author Obito
 * @Date 2021/1/19 下午1:38
 * 如果需要建立连接，java中提供了标准，数据库厂商来进行实现，包含实现子类，实现子类一般存放在安装目录下
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception{

        // 加载驱动
        /**
         * 当执行了当前代码之后，会返回一个Class对象，在此对象创建的过程中，会调用具体类的静态代码块
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 建立连接
        /**
         * 第一步中已经将driver对象注册到了drivermanager中，所以此时可以直接通过DriverManager来获取数据库的连接,需要输入数据库的参数
         */
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Obito", "root", "bjh990523");

        // 测试
        System.out.println(connection);

        // 定义SQL语句
        String sql = "select * from emp";

        // 准备静态处理块对象，将sql语句放置到静态代码块中，理解为SQL语句放置对象
        /**
         * 在执行SQL语句的过程中，需要一个对象来存放SQL语句，将对象进行执行的时候调用的是数据库的服务，数据库会从当前对象中拿到对应的SQL语句进行执行
         * statement在执行的时候可以选择三种方式：
         *  1.execute：任何SQL语句都可以执行
         *  2.executeQuery：只能执行查询语句
         *  3.executeUpdate：只能执行CRUD语句
         */
        Statement statement = connection.createStatement();

        // 执行SQL语句，返回值对象是结果集合，需要进行循环迭代才能获取到其中的数据
        ResultSet resultSet = statement.executeQuery(sql);

        // 循环处理
        /**
         * 使用while循环，有两种具体的实现方式，第一种通过下标索引编号来获取，从1开始，第二种是通过列名来获取，推荐使用列名，列名一般不会发生修改
         */
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
            String name = resultSet.getString("name");
            System.out.println(name);
            System.out.println("-------------");
        }

        // 关闭连接
        statement.close();
        connection.close();

    }
}
