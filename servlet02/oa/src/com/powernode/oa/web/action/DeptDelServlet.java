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
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-05
 * Time: 16:31
 */
public class DeptDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
