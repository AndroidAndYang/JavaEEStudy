package com.seabig.servlet_scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: YJZ
 * data: 2018/4/3.
 */

@WebServlet("/result")
public class ResultServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer numInRequest = (Integer) req.getAttribute("NUM_IN_REQUEST");

        HttpSession session = req.getSession();
        Integer numInSession = (Integer) session.getAttribute("NUM_IN_SESSION");

        ServletContext servletContext = req.getServletContext();
        Integer numInContext = (Integer) servletContext.getAttribute("NUM_IN_CONTEXT");

        PrintWriter out = resp.getWriter();

        out.print("<html>");
        out.print("<body>");

        out.print("request:" + numInRequest + "<br>");
        out.print("session:" + numInSession + "<br>");
        out.print("servletContext:" + numInContext + "<br>");

        out.print("</body>");
        out.print("</html>");

    }
}
