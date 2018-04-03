package com.seabig.cookie_session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * @author: YJZ
 * data: 2018/3/31.
 * des: 设置cookie和session
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决网页中问乱码情况
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        if (name.isEmpty() || pwd.isEmpty()) {
            return;
        }
        // 将用户名添加到cookie中，存储方式key-value.
        // cookie只能存储string类型的数据,并且有大小限制
        // cookie中不支持中文.使用URLEncoder对存储值设置编码,在获取的地方法使用URLDecoder.decode(cookie_session.getValue(), "UTF-8");进行解码
        Cookie cookie = new Cookie("currentName", URLEncoder.encode("account", "UTF-8"));

        // 设置Cooike数据,如果需要更新之前的数据只需要在重新添加和之前一样名字的值即可
        resp.addCookie(cookie);
        Cookie pwdCookie = new Cookie("pwd", pwd);
        resp.addCookie(pwdCookie);

        HttpSession session = req.getSession(true);
        // 设置session数据,session可以设置object数据类型
        session.setAttribute("account", name);
        session.setAttribute("pwd", pwd);
        // 删除一个session
        // session.removeAttribute("account");
        // 设置session的存在时间
        // session.setMaxInactiveInterval(60);

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1> 欢迎 " + name + "</h1>");
        out.println("<a href='/email'> 1234 </a>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");

    }
}
