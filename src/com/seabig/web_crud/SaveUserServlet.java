package com.seabig.web_crud;

import com.seabig.jdbc.dao.IStudentDAO;
import com.seabig.jdbc.dao.impl.StudentDAOImpl;
import com.seabig.jdbc.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/9.
 * des: 保存信息
 */
@WebServlet("/user/save")
public class SaveUserServlet extends HttpServlet {

    private IStudentDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("name =" + name);
        System.out.println("age =" + age);

        // id 为空表示新增
        if (id.isEmpty()) {
            Student student = new Student();
            student.setAge(Integer.parseInt(age));
            student.setName(name);
            dao.save(student);
        } else {
            // 不为空表示更新
            Student student = new Student();
            student.setId(Integer.parseInt(id));
            student.setAge(Integer.parseInt(age));
            student.setName(name);
            dao.update(student);
        }
        resp.sendRedirect("/user/list");
//        req.getRequestDispatcher("/user/list").forward(req, resp);
    }
}
