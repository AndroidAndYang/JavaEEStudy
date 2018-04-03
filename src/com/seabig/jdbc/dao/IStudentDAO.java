package com.seabig.jdbc.dao;


import com.seabig.jdbc.domain.Student;

import java.util.List;

/**
 * @author: YJZ
 * data: 2018/3/27.
 */
public interface IStudentDAO {

    void save(Student student);

    void delete(int id);

    void update(Student student);

    Student query(int id);

    List<Student> queryAll();

}
