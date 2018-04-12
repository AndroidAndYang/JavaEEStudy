package com.seabig.upload;

import com.seabig.exception.MyException;
import com.seabig.util.FileUploadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/11.
 * des: 文件上传
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String headImg = req.getParameter("headImg");
        // 如果表单提交使用multipart/form-data编码之后，就不能使用req.getParameter(）方式获取共享数据
        System.out.println("name =" + name);
        System.out.println("age =" + age);
        System.out.println("headImg =" + headImg);
        try {
            // 通过对上传文件的封装,处理上传过程中出现的异常
            FileUploadUtil.load(req);
        } catch (MyException e) {
            req.setAttribute("errMsg", e.getMessage());
            req.getRequestDispatcher("/upload/upload.jsp").forward(req, resp);
        }
    }
}
