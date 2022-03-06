package com.powernode.oa.web.action;

import com.powernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
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
 * Date: 2022-03-05
 * Time: 15:07
 */
public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
}
