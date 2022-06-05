package com.swei;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-04
 * Time: 8:59
 */

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf8");

        PrintWriter writer = resp.getWriter();
        writer.write(String.valueOf(req.getRequestURL()));
        writer.write("<hr/>");
        writer.write(req.getMethod());
        writer.write("<hr/>");
        writer.write(req.getParameter("name"));
        writer.write("<hr/>");
        writer.write(req.getQueryString());
        writer.write("<hr/>");
        writer.write(req.getContextPath());
        writer.write("<hr/>");
        writer.println(req.getHeaderNames());

        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String headName = names.nextElement();
            String header = req.getHeader(headName);
            writer.write(headName + ":" + header + "<hr/>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}


