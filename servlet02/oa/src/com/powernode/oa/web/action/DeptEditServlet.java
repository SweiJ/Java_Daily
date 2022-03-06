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
 * Time: 19:21
 */
public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
}
