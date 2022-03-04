package com.powernode.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-04
 * Time: 9:28
 */
public class HelloServlet extends HttpServlet {
    // 通过无参构造方法创建对象
    /*public HelloServlet() {
    }*/

    // 使用servlet的转发机制
    // 执行一个servlet之后,跳转到另外一个servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 既然继承了 HttpServlet 就没必要重写service方法.
     * 因为 HttpServlet 为我们提供了七种请求方法,重写 service 方法可以避免405错误
     *
     @Override
     public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
         super.service(req, res);
     }
     */

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print("helloServlet!");
//
//        // 浏览器向服务器发送的数据
//        // 将数据中的name打印出来
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while(parameterNames.hasMoreElements()) {
//            String tem = parameterNames.nextElement();
//            System.out.println(tem);
//        }
//        String[] ns = request.getParameterValues("n");
//
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        Set<String> strings = parameterMap.keySet();
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }


    //
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("helloServlet!");

        RequestDispatcher dis = request.getRequestDispatcher("/hello");
    }
}
