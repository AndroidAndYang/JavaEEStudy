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
 * des: 编辑用户信息,通过A标签请求servlet之后跳转到jsp中
 */

@WebServlet("/user/edit")
public class EditUserServlet extends HttpServlet {

    private IStudentDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("edit");
        String id = req.getParameter("id");
        // id 为空表示新增,不为空表示编辑
        if (id != null && !id.equals("")) {
            Student user = dao.query(Integer.parseInt(id));
            req.setAttribute("user", user);
        }
        req.getRequestDispatcher("/WEB-INF/views/web_crud/EditUser.jsp").forward(req, resp);
    }
}
