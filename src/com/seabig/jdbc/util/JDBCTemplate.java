package com.seabig.jdbc.util;


import com.seabig.jdbc.helper.IResultSetHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author: YJZ
 * data: 2018/3/28.
 * des 对增删改进行抽取
 */
public class JDBCTemplate {

    // DML操作 对增删改方法进行抽取,参数的值使用可变参数替代
    public static void dmlOperate(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1.加载注册驱动
            // 2.获取连接
            connection = DAOUtil.getConnection();
            // 3. 编写Sql语句
            // 4.执行sql
            statement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            // 为 0 表示已影响的行数
            System.out.println(sql);
            int saveRes = statement.executeUpdate();
            System.out.print(saveRes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
            DAOUtil.close(connection, statement, null);
        }
    }

    // DQL操作
    public static <T> T dqlOperate(String sql, IResultSetHelper<T> helper, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.加载注册驱动
            // 2.获取连接
            connection = DAOUtil.getConnection();
            // 3. 编写Sql语句
            // 4.执行sql
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            // 为 true 表示已影响的行数
            resultSet = statement.executeQuery();
            return helper.hand(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
            DAOUtil.close(connection, statement, resultSet);
        }
        return null;
    }

}
