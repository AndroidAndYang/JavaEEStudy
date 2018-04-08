package com.seabig.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author: YJZ
 * data: 2018/4/7.
 * des: 复习
 */
public class JdbcDemo {


    public static void main(String[] args) throws Exception {
        // 加载注册驱动
        Class.forName("jdbc.mysql.Driver");
        // 连接数据库
        Connection connection = DriverManager.getConnection("local", "", "");
        // sql语句
        String sql = "SELECT * FROM USER";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

        connection.close();
        statement.close();
    }
}
