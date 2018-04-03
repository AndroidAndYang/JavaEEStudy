package com.seabig.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/3.
 * des: URL重定向: 1) 地址栏会改变
 *                2) 两次请求
 *                3) 不能共享请求数据
 *                4) 不能访问web-info下的资源
 *                5) 支持跨域访问
 */

@WebServlet("/redirect/one")
public class RedirectOneServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("RedirectOneServlet init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectOneServlet service() init");
        // 跨域访问
        // resp.sendRedirect("https://www.baidu.com/");
        resp.sendRedirect("/redirect/two");
        System.out.println("RedirectOneServlet service() Running");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("RedirectOneServlet destroy()");
    }
}
