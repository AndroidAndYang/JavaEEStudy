package com.seabig.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/18.
 * des: 经过filter过滤的登录Servlet
 */

@WebServlet("/filter/login")
public class LoginFilterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.getSession().setAttribute("USER_IN_SESSION", name);
        resp.sendRedirect("/filter/LoginSuccess.jsp");
    }
}
