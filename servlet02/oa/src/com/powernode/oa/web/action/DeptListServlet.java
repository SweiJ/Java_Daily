package com.powernode.oa.web.action;

import com.powernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-05
 * Time: 12:58
 */
public class DeptListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
}
