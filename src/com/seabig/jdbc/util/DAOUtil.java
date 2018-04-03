package com.seabig.jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: YJZ
 * data: 2018/3/27.
 */
public class DAOUtil {

    public static Properties p;
    public static DataSource dataSource;

    //静态代码块，只加载一次，优先执行。
    static {
        // 1.加载注册驱动
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("db.properties");
            p = new Properties();
            p.load(inputStream);
            // 不是用连接池
            // Class.forName(p.getProperty("driverClassName"));
            // 使用连接池
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        // 2.获取连接
        try {
            // 使用连接池连接数据库
            return dataSource.getConnection();
            // 不是用连接池连接数据库
            // return DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("数据库连接失败");
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
