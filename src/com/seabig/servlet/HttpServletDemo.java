package com.seabig.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/3/29.
 */
public class HttpServletDemo extends HttpServlet {

    // 初始化方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("HttpServletDemo init");

        String name = this.getInitParameter("key");
        System.out.println(name);
    }

    // 可以接受POST请求和GET请求
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("HttpServletDemo service");
        String method = req.getMethod();
        System.out.println("method =" + method);

        String contextPath = req.getContextPath();
        System.out.println("contextPath =" + contextPath);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL =" + requestURL);

        String name = req.getParameter("name");
        System.out.println("name =" + name);

    }

    // 当HttpServlet子类中,如果实现了service方法.doGet 和doPost()方法不会执行
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用父类的方法需要注释,不然会报 HTTP method GET is not supported by this URL 错误
        // super.doGet(req, resp);

        String method = req.getMethod();
        System.out.println("method =" + method);

        String contextPath = req.getContextPath();
        System.out.println("contextPath =" + contextPath);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL =" + requestURL);

        String name = req.getParameter("name");
        System.out.println("name =" + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用父类的方法需要注释
        // super.doPost(req, resp);
        System.out.println("HttpServletDemo doPost");
    }
}
