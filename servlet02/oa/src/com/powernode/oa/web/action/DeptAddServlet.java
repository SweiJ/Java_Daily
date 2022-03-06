package com.powernode.oa.web.action;

import com.powernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-05
 * Time: 17:18
 */
public class DeptAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
}
