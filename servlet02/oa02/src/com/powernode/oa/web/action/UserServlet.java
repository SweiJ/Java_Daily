package com.powernode.oa.web.action;

import com.powernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-07
 * Time: 15:59
 */
@WebServlet({"/user/login"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户提交的数据
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");

        // 根据数据库查询是否存在
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Boolean flag = false;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_user where username=? and passwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, passwd);

            rs = ps.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        // 登陆成功/失败
        if(flag) {
            // 登陆成功 如果没有session对象就创建
            HttpSession session = request.getSession();
            // 将username 绑定到session 会话域中
            session.setAttribute("username",username);

            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
