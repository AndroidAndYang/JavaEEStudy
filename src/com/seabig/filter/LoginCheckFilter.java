package com.seabig.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/18.
 * des: 登陸請求的过滤，用于没有登录的情况去访问登录后的页面信息
 */
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HelloFilter doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取登录之后存储的session,用于判断是否有登录过
        Object userInSession = request.getSession().getAttribute("USER_IN_SESSION");

        String requestUrl = String.valueOf(request.getRequestURL());
        // 判断是否时登录的请求，如果是登录的请求就不需要过滤
        if (!requestUrl.contains("/filter/login")) {
            // 判断是否登录过
            if (userInSession == null) {
                response.sendRedirect("/filter/LoginFilter.jsp");
                return;
            }
        }
        // 放行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
