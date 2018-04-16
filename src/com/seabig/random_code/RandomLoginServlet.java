package com.seabig.random_code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/16.
 * des: 验证码登录
 */
@WebServlet("/randomLogin")
public class RandomLoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String code = req.getParameter("code");
        String randomCodeInSession = (String) req.getSession().getAttribute("RANDOM_CODE_IN_SESSION");

        // 验证码输入的不正确
        if (!code.equals(randomCodeInSession)) {
            req.setAttribute("errMsg", "验证码不正确或已过期");
            req.setAttribute("name", name);
            req.setAttribute("pwd", pwd);
            req.getRequestDispatcher("/random_code/randomCode.jsp").forward(req, resp);
            return;
        }

        // 登录成功销毁session,防止返回依旧可以登录
        req.getSession().removeAttribute("RANDOM_CODE_IN_SESSION");
        System.out.println("登录成功");
        System.out.println("登录检查");
    }
}
