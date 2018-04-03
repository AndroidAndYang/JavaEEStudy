package com.seabig.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author: YJZ
 * data: 2018/3/26.
 * des: 最初版
 */
public class JdBcDemo {

    public static void main(String[] args) {
        String connectionURL = "jdbc:mysql://localhost:3306/test_db";
        String mysqlName = "root";
        String mysqlPwd = "admin";
        Connection connection = null;
        try {
            // 1.加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.连接数据库
            connection = DriverManager.getConnection(connectionURL, mysqlName, mysqlPwd);
            // 3.执行sql语句
            String sql = "select * from test_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                System.out.println("ID:" + resultSet.getInt("id"));

                System.out.println("用户名:" + resultSet.getString("name"));

                System.out.println("年龄:" + resultSet.getInt("age"));

                System.out.println("性别:" + resultSet.getString("sex"));

                System.out.println("-------------------------------------");
            }

            statement.close();
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
