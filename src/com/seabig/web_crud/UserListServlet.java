package com.seabig.web_crud;

import com.seabig.jdbc.dao.IStudentDAO;
import com.seabig.jdbc.dao.impl.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/8.
 */
@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {

    private IStudentDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user_data", dao.queryAll());
        req.getRequestDispatcher("/WEB-INF/views/web_crud.jsp").forward(req,resp);
    }
}
