package com.powernode.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-05
 * Time: 8:59
 */
public class Aservlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        /* 以下四种方法都是获取前端提交的数据
//            request.getParameterValues(String name)  // 根据name获取所有的value值
//            request.getParameterNames()  // 获取浏览器提交的所有的name
//            request.getParameterMap()  // 获取所有name和vlaue的map集合
//            request.getParameter(String name)  // 获取value数组的第一个元素
//         */
//        // request.getParameterValues("interest") 该方法输出的是浏览器提交的数据
//        String[] interests = request.getParameterValues("interest");
//        // [Ljava.lang.String;@240dfb50 代表字符数组的输出
////        System.out.println(interests);
//
//        for (String interest : interests) {
//            System.out.println(interest);
//        }
//
//        // 输出提交表单的所有name属性
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while(parameterNames.hasMoreElements()) {
//            String s = parameterNames.nextElement();
//            System.out.println(s);
//        }
//
//        // 该方法获取的是浏览器提交的 name属性 和 value属性值
////        Map<String, String[]> parameterMap = request.getParameterMap();
////        Set<String> strings = parameterMap.keySet();
////        for (String string : strings) {
////            String[] parameterValues = request.getParameterValues(string);
////            System.out.print(string + "=");
////            for (String parameterValue : parameterValues) {
////                System.out.print(parameterValue + ',');
////            }
////            System.out.println();
////        }
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//
//        // 增强for循环输出所有的表单数据
//        for (Map.Entry<String, String[]> entry : entries) {
//            System.out.print(entry.getKey() + "=");
//            String[] value = entry.getValue();
//            for (String s : value) {
//                System.out.print(s + ',');
//            }
//            System.out.println();
//        }
//        System.out.println("========================");
//        // 迭代器输出数据
//        Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();
//        while(iterator.hasNext()) {
//            Map.Entry<String, String[]> next = iterator.next();
//            System.out.print(next.getKey() + "=");
//            String[] value = next.getValue();
//            for (String s : value) {
//                System.out.print(s + ',');
//            }
//            System.out.println();
//        }
//
//        String interest = request.getParameter("interest");
//        System.out.println(interest);
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 向请求域中绑定数据  请求域只在一次请求有效
//        request.setAttribute("xiao", "zhang");
//        System.out.println(request.getAttribute("xiao"));


        // 因为请求域是不可分享的  如果想要达到分享数据的作用需要利用转发机制
        // 获取转发机智的对象
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/b");
//        // 调用转发器的forward方法达成跳转/转发
//        dispatcher.forward(request, response);

//        request.getRequestDispatcher("/b").forward(request, response);



        // 获取应用的根路径
        String contextPath = request.getContextPath();

        // 获取请求方式
        String method = request.getMethod();

        // 获取请求的URI
        String requestURI = request.getRequestURI();

        // 获取servlet path
        String servletPath = request.getServletPath();

        /*
            /Javaweb02
            GET
            /Javaweb02/a
            /a
         */
        System.out.println(contextPath);
        System.out.println(method);
        System.out.println(requestURI);
        System.out.println(servletPath);
    }
}
