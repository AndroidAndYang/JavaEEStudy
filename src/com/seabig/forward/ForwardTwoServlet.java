package com.seabig.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/3.
 */
@WebServlet(value = "/forward/two", initParams = @WebInitParam(name = "key", value = "value2"))
public class ForwardTwoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("ForwardTwo init");
        // 获取初始化参数
        String key = getServletConfig().getInitParameter("key");
        System.out.println("ForwardTwoServlet key = " + key);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接受ForWardOneServlet请求的参数
        String params = req.getParameter("params");
        System.out.println("接受到ForwardOneServlet中的请求参数" + params);

        System.out.println("ForwardTwoServlet running");
    }

    @Override
    public void destroy() {
        System.out.println("ForwardTwoServlet destroy");
    }
}
