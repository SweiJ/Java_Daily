<%--
  Created by IntelliJ IDEA.
  User: SweiPC
  Date: 2022/3/7
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>

<%--jsp的作用是将原始写在java程序里的前端代码翻译成 servlet java程序--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--下面的代码会被 tomcat 翻译成 out.write(); --%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>

<%-- 被<% %>扩住的代码块是java代码,由tomcat翻译在service方法里的java代码 --%>
<%--注意: 该代码块不能为静态代码块, 方法 与java语法相同--%>
<% System.out.println("xiaojiang"); %>

<%-- 被<%! %>扩住的代码由tomcat编译在service方法外, 可以是静态代码 一般很少使用--%>
<%! static int a = 10; %>

<%-- 被<%= %>扩住的由tomcat编译为 out.write();--%>
<%--注意: 不能带; 一般被包含的是变量--%>
<%= 100 + 200 %>