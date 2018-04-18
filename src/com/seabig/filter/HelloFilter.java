package com.seabig.filter;


import com.seabig.util.TextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/18.
 * des: 过滤器
 * filter：和servlet一样都是web中的组件，和Servlet一样都需要在web.xml中配置或者使用@WebFilter配置
 * 在tomcat启动时，Filter启动，客户端每请求一次都会执行doFilter方法。tomcat关闭时filter关闭。
 * 和servlet不同的是 servlet在请求时才会初始化，filter在tomcat启动时就会初始化。销毁都是在tomcat关闭时才会销毁。
 **/

public class HelloFilter implements Filter {

    // 文字编码格式，如果web.xml中沒有配置则这里默认值为UTF-8
    private String encode = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取在Web.xml中配置的初始化参数
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HelloFilter doFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求的编码类型,为空表示没有自己设置编码的格式。我们可以对其进行编码设置。
        String encoding = request.getCharacterEncoding();
        if (TextUtils.isEmpty(encoding)) {
            // 对所有的请求都设置编码
            request.setCharacterEncoding(encode);
        }

        // 表示放行，不拦截此次的请求
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("HelloFilter destroy");
    }
}
