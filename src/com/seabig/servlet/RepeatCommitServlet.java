package com.seabig.servlet;

import com.seabig.util.TokenUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/19.
 * des: 表单的重复提交
 * 1) 返回键
 * 2）页面刷新
 * 3) 网络延迟
 */
@WebServlet("/repeat/commit")
public class RepeatCommitServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("id");
        if (TokenUtil.checkToken(req, uuid)) {
            System.out.println("转账成功");
        }
        System.out.println("请重新提交");
    }
}
