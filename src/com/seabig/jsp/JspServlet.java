package com.seabig.jsp;

import com.seabig.jdbc.dao.IStudentDAO;
import com.seabig.jdbc.dao.impl.StudentDAOImpl;
import com.seabig.jdbc.domain.Student;
import com.seabig.jdbc.util.JDBCTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: YJZ
 * data: 2018/4/7.
 * des: servlet跳转到JSP中
 */
@WebServlet("/jsp")
public class JspServlet extends HttpServlet {

    private IStudentDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = dao.queryAll();
        req.setAttribute("list_data", students);
        req.getRequestDispatcher("/WEB-INF/views/ListUser.jsp").forward(req, resp);
    }
}
