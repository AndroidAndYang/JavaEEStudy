package com.seabig.jdbc.helper;


import java.sql.ResultSet;

/**
 * @author: YJZ
 * data: 2018/3/28.
 */
public interface IResultSetHelper<T> {

    T hand(ResultSet resultSet) throws Exception;
}
