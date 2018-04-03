package com.seabig.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/3/29.
 * des：Servlet是单例的.Servlet只要第一次请求之后,创建好一个对象,该对象就一直存在,直到Tomcat关闭.
        一个Servlet类,最多之后一个实例.(单实例,性能有保证,但是多个线程并发可能造成安全问题).
 */
public class HelloServlet implements Servlet {

    /**
     * 初始化方法
     * 只在第一次请求时,创建好Servlet对象之后,做初始化操作.
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    /**
     * 获取当前Servlet的配置信息对象.
     *
     * @return Servlet的配置信息
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 服务方法，每次请求都会执行,处理请求的.
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    /**
     * 用于返回当前Servlet的作者,版本,版权信息
     *
     * @return Servlet的作者, 版本, 版权信息
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * Servlet销毁方法
     * 在Tomcat正常关闭的时候执行,不要期望该方法一定会执行,不需要把扫尾的操作存放在这里.
     */
    @Override
    public void destroy() {

    }
}
