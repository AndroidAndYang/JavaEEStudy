package com.seabig.jdbc.dao.impl;

import com.seabig.jdbc.dao.IStudentDAO;
import com.seabig.jdbc.domain.Student;
import com.seabig.jdbc.helper.BeanInfoHelper;
import com.seabig.jdbc.helper.BeanInfoListHelper;
import com.seabig.jdbc.util.JDBCTemplate;

import java.util.List;

/**
 * @author: YJZ
 * data: 2018/3/27.
 * <p>
 * int executeUpdate(String sql):执行DDL/DML语句.
 * 若当前SQL是DDL语句,则返回0.
 * 若当前SQL是DML语句,则返回受影响的行数.
 * <p>
 * executeQuery(String sql):执行DQL语句,返回结果集.
 * <p>
 * 1. 数据查询语言DQL 数据查询语言DQL基本结构是由SELECT子句，FROM子句，WHERE 子句组成的查询块： SELECT <字段名表> FROM <表或视图名> WHERE <查询条件>
 * 2 .数据操纵语言DML 数据操纵语言DML主要有三种形式： 1) 插入：INSERT 2) 更新：UPDATE 3) 删除：DELETE
 * 3. 数据定义语言DDL 数据定义语言DDL用来创建数据库中的各种对象-----表、视图、 索引、同义词、聚簇等如： CREATE TABLE/VIEW/INDEX/SYN/CLUSTER | | | | | 表 视图 索引 同义词 簇
 */
public class StudentDAOImpl implements IStudentDAO {

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO user (name,age) VALUES(?,?)";
        JDBCTemplate.dmlOperate(sql, student.getName(), student.getAge());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE ID = ?";
        JDBCTemplate.dmlOperate(sql, id);
    }

    @Override
    public void update(Student student) {
        // 3. 编写Sql语句
        String sql = "UPDATE user SET name = ?,age = ? WHERE id = ? ";
        JDBCTemplate.dmlOperate(sql, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public Student query(int id) {
        String sql = "SELECT * FROM user WHERE id = ? ";
        BeanInfoHelper<Student> baseResultHelper = new BeanInfoHelper<>(Student.class);
        return JDBCTemplate.dqlOperate(sql, baseResultHelper, id);
    }

    @Override
    public List<Student> queryAll() {
        String sql = "SELECT * FROM user";
        return JDBCTemplate.dqlOperate(sql, new BeanInfoListHelper<>(Student.class));

    }
}
