package com.powernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-02-26
 * Time: 15:03
 */
public class StudentServlet implements Servlet {
    /**
     * 构造方法只执行一次，当调用该对象时
     * 但是tomacat不会直接调用该对象需要在web.xml文件中加上<load-on-startup>0</load-on-startup>
     * 不要使用有参构造方法
     */
    public StudentServlet() {
        System.out.println("StudentServlet.StudentServlet创建对象!");
    }

    /**
     * 该方法为初始化方法，在创建对象之后运行，因为init方法是依赖于对象的
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("StudentServlet.init初始化!");
    }

    /**
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 处理用户请求的核心方法
     * 提供服务，当浏览器发送请求的时候该服务会执行一次
     * 当有100次请求，该方法就执行100次
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        // jdbc
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/powernode?characterEncoding-utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            String user = "root";
            String password = "jsw";
            conn = DriverManager.getConnection(url, user, password);

            String sql = "select * from student01";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                String age = rs.getString("age");
                out.print(name + " " + age + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 该方法也是只执行一次
     * Tomcat服务器在销毁StudentServlet对象之前会调用
     * 当该方法执行的时候，StudentServlet对象的内存还没有被销毁
     * 该方法可以写销毁前的准备
     */
    @Override
    public void destroy() {

    }
}
