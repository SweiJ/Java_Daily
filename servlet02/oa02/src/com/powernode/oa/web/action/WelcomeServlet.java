package com.powernode.oa.web.action;

import com.powernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-08
 * Time: 12:23
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求中所有的cookie
        // 我们在登陆成功之后会创建两个cookie 分别是username和passwd
        Cookie[] cookies = request.getCookies();

        String username = null;
        String passwd = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("username".equals(name)) {
                    username = cookie.getValue();
                } else if("passwd".equals(name)) {
                    passwd = cookie.getValue();
                }
            }
        }
        // 表明登陆成功并且获取到cookie值
        if(username != null && passwd != null) {
            // 根据数据库查询是否存在
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Boolean success = false;
            try {
                conn = DBUtil.getConnection();
                String sql = "select * from t_user where username=? and passwd=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, passwd);

                rs = ps.executeQuery();
                if(rs.next()) {
                    success = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(conn, ps, rs);
            }
            // 登陆成功/失败
            if(success) {
                // 登陆成功 如果没有session对象就创建
                HttpSession session = request.getSession();
                // 将username 绑定到session 会话域中
                session.setAttribute("username",username);

                response.sendRedirect(request.getContextPath() + "/dept/list");
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
}
