package com.seabig.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: YJZ
 * data: 2018/3/30.
 */
public class OptServlet extends HttpServlet {

    /**
     * 初始化操作
     *
     * @param config 用于获取Servlet的配置信息
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String num1 = req.getParameter("num1");
        String opt = req.getParameter("opt");
        String num2 = req.getParameter("num2");

        System.out.println("num1 =" + num1 + "  num2 = " + num2);

        String result = "";

        if (opt.isEmpty() || num1.isEmpty() || num2.isEmpty()) {
            System.out.println("内容为空");
            return;
        }

        Integer one = Integer.valueOf(num1);
        Integer two = Integer.valueOf(num2);

        switch (opt) {
            case "+":
                result = String.valueOf(one + two);
                break;
            case "-":
                result = String.valueOf(one - two);
                break;
            case "*":
                result = String.valueOf(one * two);
                break;
            case "/":
                result = String.valueOf(one / two);
                break;
        }

        System.out.println(result);

        PrintWriter out = resp.getWriter();
        // 输出Html,后面使用JSP代替
        out.println("<html>");
        out.println("<body>");
        out.print("<form action='/opt' method='post'>");
        out.print("<input type='number' value = '" + num1 + "' readonly/>");
        out.print("<select name='opt'>");
        out.print("<option>+</option>");
        out.print("<option>-</option>");
        out.print("<option>*</option>");
        out.print("<option>/</option>");
        out.print("</select>");
        out.print("<input type='number' value ='" + num2 + "' readonly/>");
        out.print("<button type='submit'>=</button>");
        out.print("<input value='" + result + "' readonly/>");
        out.print("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
