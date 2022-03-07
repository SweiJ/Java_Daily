package com.powernode.oa.web.action;

import com.powernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-06
 * Time: 17:51
 */
//@WebServlet({"/dept/list","/dept/detail","/dept/delete","/dept/add","/dept/edit","/dept/modify"})
@WebServlet("/dept/*")
public class DeptServelt extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/dept/list".equals(servletPath)) {
            doList(request, response);
        } else if("/dept/detail".equals(servletPath)) {
            doDetail(request, response);
        } else if("/dept/delete".equals(servletPath)) {
            doDel(request, response);
        } else if("/dept/add".equals(servletPath)) {
            doAdd(request, response);
        } else if("/dept/edit".equals(servletPath)) {
            doEdit(request, response);
        } else if("/dept/modify".equals(servletPath)) {
            doModify(request, response);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        // 避免出现中文乱码问题 tomcat10 一下会有
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取根路径
        String contextPath = request.getContextPath();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("<title>部门列表页面</title>");

        out.print("<script type='text/javascript'>");
        out.print("        function del(dno) {");
        out.print("    if(window.confirm('亲,删除了就不能恢复了!')) {");
        // 前端向后端发送请求
        out.print("        document.location.href = '"+ contextPath +"/dept/delete?deptno=' + dno");
        out.print("    }");
        out.print("}");
        out.print("</script>");

        out.print("</head>");
        out.print("<body>");
        out.print("<h1 align='center'>部门列表</h1>");
        out.print("<hr >");
        out.print("<table border='1px' align='center' width='50%'>");
        out.print("<tr>");
        out.print("<th>序号:</th>");
        out.print("<th>部门编号:</th>");
        out.print("<th>部门名称:</th>");
        out.print("<th>操作</th>");
        out.print("</tr>");

        // 数据库的连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT deptno AS a, dname, loc FROM dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 1;
            while (rs.next()) {
                String deptno = rs.getString("a");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("<tr>");
                out.print("<td>" + (i++) + "</td>");
                out.print("<td>" + deptno + "</td>");
                out.print("<td>" + dname + "</td>");
                out.print("<td>");
                out.print("<a href='javascript:void(0)' onclick='del(" + deptno + ")'>删除</a>");
                out.print("<a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>");
                // contextPath 获取项目根路径 加上详情页的子路径 ? 后面的是get请求的数据
                // http://localhost:8080/oa/dept/detail?deptno=10
                out.print("<a href='" + contextPath + "/dept/detail?deptno=" + deptno + "'>详情</a>");
                out.print("</td>");
                out.print("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // 关闭流
            DBUtil.close(conn, ps, rs);
        }

        out.print("</table>");
        out.print("<hr >");
        out.print("<a href='"+ contextPath +"/add.html'>新增部门</a>");
        out.print("</body>");
        out.print("</html>");
    }
    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 避免出现中文乱码问题 tomcat10 以下会有
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>部门详情</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("  <h1>部门详情</h1>");
        out.print("    <hr >");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 获取get请求中request的数据
        String deptno = request.getParameter("deptno");

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT dname, loc FROM dept WHERE deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            while (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("                部门编号: " + deptno + " <br>");
                out.print("                部门名称: " + dname + " <br>");
                out.print("        部门位置: " + loc + " <br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(conn, ps, rs);
        }

        out.print("    <input type='button' value='返回' onclick='window.history.back()'/>");
        out.print("</body>");
        out.print("</html>");
    }
    private void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // 获取数据
        String deptno = request.getParameter("deptno");
        // 根据部门编号删除数据
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            // 关闭自动提交
            conn.setAutoCommit(false);
            String sql = "DELETE FROM dept WHERE deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            // 记录被修改的次数
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
        if(count == 1) {
            // 转发请求到list
            request.getRequestDispatcher("/dept/list").forward(request, response);
        } else {
            request.getRequestDispatcher("/error.html").forward(request, response);
        }
    }
    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");

        // 获取浏览器提交的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        // 连接数据库 添加数据到数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into dept(deptno, dname, loc) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        if(count == 1) {
            // 转发 转发的请求需要doPost接收
//            request.getRequestDispatcher("/dept/list").forward(request, response);
            // 重定向 不需要doPost接收
            response.sendRedirect("/oa/dept/list");
        } else {
//            request.getRequestDispatcher("/error.html").forward(request, response);
            response.sendRedirect("/error.html");
        }
    }
    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>修改部门</h1>");
        out.print("    <hr >");
        out.print("    <form action='/oa/dept/modify' method='post'>");

        // 获取浏览器提交的数据
        String deptno = request.getParameter("deptno");

        // 连接数据库 添加数据到数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select dname, loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            while(rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("部门编号<input type='text' name='deptno' value='"+deptno+" ' readonly /> <br>");
                out.print("部门名称<input type='text' name='dname' value='"+dname+" '/> <br>");
                out.print("部门位置<input type='text' name='loc' value='"+loc+" '/> <br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        out.print("      <input type='submit' name='保存'/><br>");
        out.print("    </form>");
        out.print("</body>");
        out.print("</html>");
    }
    private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");

        // 获取浏览器提交的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        // 连接数据库 添加数据到数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE dept SET dname=?, loc=? WHERE deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setString(2, loc);
            ps.setString(3, deptno);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        if(count == 1) {
            // 转发 转发的请求需要doPost接收
//            request.getRequestDispatcher("/dept/list").forward(request, response);
            // 重定向 不需要doPost接收
            response.sendRedirect("/oa/dept/list");
        } else {
//            request.getRequestDispatcher("/error.html").forward(request, response);
            response.sendRedirect("/error.html");
        }
    }


}