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
 * des 请求转发: 1) 请求转发地址栏不会改变
 *              2) 只会请求一次
 *              3) 能共享请求数据
 *              4) 能访问web-info下的资源
 *              5) 不支持跨域访问
 */

// 使用注解方式配置servlet,在web.xml中需要将 metadata-complete="false",不然无法使用
@WebServlet(value = "/forward/one", initParams = @WebInitParam(name = "key", value = "value1"))
public class ForWardOneServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("ForWardOneServlet init");

        String key = getServletConfig().getInitParameter("key");
        System.out.println(" ForWardOneServlet key =" + key);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ForWardOneServlet service");

        // 请求转发到ForwardTwoServlet
        req.getRequestDispatcher("/forward/two").forward(req, resp);

        System.out.println("ForWardOneServlet running");
    }

    @Override
    public void destroy() {
        System.out.println("ForWardOneServlet destroy");
    }
}
