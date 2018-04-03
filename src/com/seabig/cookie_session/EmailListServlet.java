package com.seabig.cookie_session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author: YJZ
 * data: 2018/4/1.
 * * des: 接受cookie和session
 */
public class EmailListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决网页中文乱码情况
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取存储的Cooike，根据存储的name来获取
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            // 获取存储的account
            if (cookie.getName().equals("account")) {
                // 获取使用URLEncoder对存储的值进行编码的
                String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                System.out.println("cookie_session value = " + value);
            }
            // 获取存储的pwd
            if (cookie.getName().equals("pwd")) {
                String value = cookie.getValue();
                System.out.println("cookie_session value = " + value);
            }
        }

        // 获取session
        // true表示:如果当前存在Session对象,则直接返回,如果当前没有Session对象,先创建一个Session对象,再返回.
        // false表示:如果当前存在Session对象,则直接返回,如果没有,在则返回null.
        HttpSession session = req.getSession(false);
        if (session != null) {
            System.out.println("session value = " + session.getAttribute("account"));
            System.out.println("session value = " + session.getAttribute("pwd"));
        }
    }
}
