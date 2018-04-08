package com.seabig.jdbc.test;

import com.seabig.jdbc.dao.IStudentDAO;
import com.seabig.jdbc.dao.impl.StudentDAOImpl;
import com.seabig.jdbc.domain.Student;

import java.util.List;

/**
 * @author: YJZ
 * data: 2018/3/27.
 */
public class StudentDAOTest {

    public static void main(String[] args) {
        IStudentDAO dao = new StudentDAOImpl();
        Student student = new Student();
        student.setId(5);
        student.setName("yjz");
        student.setAge(18);
//        dao.save(student);
//        dao.delete(4);
//        dao.dmlOperate(student);
        Student student1 = dao.query(2);
        System.out.println(student1.toString());

        List<Student> students = dao.queryAll();
        for (Student student2:students){
            System.out.println(student2.toString());
        }
        System.out.println(students.size());
    }
}
