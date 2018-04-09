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
 * data: 2018/4/9.
 * des:  删除用户信息
 */
@WebServlet("/user/delete")
public class DeleteUserServlet extends HttpServlet {

    private IStudentDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("id = " + id);
        dao.delete(Integer.parseInt(id));
        resp.sendRedirect("/user/list");
//        req.getRequestDispatcher("/user/list").forward(req,resp);
    }
}
