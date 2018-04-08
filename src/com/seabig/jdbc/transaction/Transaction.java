package com.seabig.jdbc.transaction;

import com.seabig.jdbc.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: YJZ
 * data: 2018/3/28.
 * des: JDBC中事务的操作
 */
public class Transaction {

    public static void main(String[] args) {

        String insertSql = "UPDATE account SET balance = balance + ? Where name = ?";

        String querySql = "select balance from account where name = ? and balance >= ?";

        String updateSql = "UPDATE account SET balance = balance - ? Where name = ?";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {

            connection = DAOUtil.getConnection();
            // 设置为手动提交
            connection.setAutoCommit(false);

            // 查询余额是否大于1000
            preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, "YJZ");
            preparedStatement.setDouble(2, 1000);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("亲，余额不足请充值！");
                return;
            }

            // 扣除1000
            preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setDouble(1, 1000);
            preparedStatement.setString(2, "YJZ");
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                System.out.println("转账成功！");
            }

            // 模拟网络故障操作
            // System.out.print(1 / 0);

            // 往WY增加1000
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setDouble(1, 1000);
            preparedStatement.setString(2, "WY");
            int update = preparedStatement.executeUpdate();
            if (update == 1) {
                System.out.println("收到转账！");
            }
            // 提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                // 出现错误，回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            DAOUtil.close(connection, preparedStatement, null);
        }
    }

}
