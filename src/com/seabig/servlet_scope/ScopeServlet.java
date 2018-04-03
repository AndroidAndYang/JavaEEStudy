package com.seabig.servlet_scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/3.
 * des: Servlet 三大作用域对象 request session servletContext
 * <p>
 * 1) request： request是表示一个请求，只要发出一个请求就会创建一个request，它的作用域：仅在当前请求中有效。
 * 2) session：是一次会话，服务器会为每一个会话创建一个session对象，session中的数据可以被本次会话中的所有servlet访问，会话是从浏览器打开开始，到关闭浏览器结束。
 * 3) servletContext： 服务器启动时 为每一个项目创建一个上下文对象
 */

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.request 2.session 3.servletContext
        // 作用域对象设置参数
        // req.setAttribute("name", "request");

        // HttpSession session = req.getSession();
        // session.setAttribute("name", "session");

        // ServletContext servletContext = req.getServletContext();
        // servletContext.setAttribute("name", "context");

        Integer numInRequest = (Integer) req.getAttribute("NUM_IN_REQUEST");
        req.setAttribute("NUM_IN_REQUEST", numInRequest == null ? 1 : numInRequest + 1);

        HttpSession session = req.getSession();
        Integer numInSession = (Integer) session.getAttribute("NUM_IN_SESSION");
        session.setAttribute("NUM_IN_SESSION", numInSession == null ? 1 : numInSession + 1);

        ServletContext servletContext = req.getServletContext();
        Integer numInContext = (Integer) session.getAttribute("NUM_IN_CONTEXT");
        servletContext.setAttribute("NUM_IN_CONTEXT", numInContext == null ? 1 : numInContext + 1);

        System.out.println("servletContext.getContextPath() =" + servletContext.getContextPath());

        req.getRequestDispatcher("/result").forward(req, resp);
    }
}