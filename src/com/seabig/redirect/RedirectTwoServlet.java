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
 * des: URL重定向
 */

@WebServlet("/redirect/two")
public class RedirectTwoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("RedirectTwoServlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取RedirectOneServlet中请求的参数
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("RedirectTwoServlet service() init ");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("RedirectTwoServlet destroy()");
    }
}
