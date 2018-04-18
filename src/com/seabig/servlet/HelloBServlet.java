package com.seabig.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: YJZ
 * data: 2018/3/29.
 */
public class HelloBServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(servletConfig.getServletName());
        System.out.println(servletConfig.getServletContext());
        System.out.println(servletConfig.getInitParameterNames());

        // 获取web.xml中配置的<init-param>

        // 获取指定名称的参数值
        String name = servletConfig.getInitParameter("name");
        System.out.println("name =" + name);

        // 获取多个参数值
        Enumeration names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String paraName = (String) names.nextElement();
            String parameter = servletConfig.getInitParameter(paraName);
            System.out.println("parameter =" + parameter);
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
