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
 * Date: 2022-03-07
 * Time: 15:59
 */
@WebServlet({"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/user/login".equals(servletPath)) {
            doLogin(request,response);
        } else if("/user/exit".equals(servletPath)) {
            doExit(request,response);
        }
    }

    protected void doExit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 手动销毁session
            session.invalidate();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if("username".equals(name) || "passwd".equals(name)) {
                        cookie.setMaxAge(0);
                    }
                }
            }
            // 跳转到首页
            response.sendRedirect(request.getContextPath());
        }
    }
    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户提交的数据
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");

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

            // 获取当前用户是否选择十天内免登陆
            String f = request.getParameter("f");
            if ("1".equals(f)) {
                // 添加cookie
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("passwd", passwd);

                // 设置cookie的时长有效期
                cookie1.setMaxAge(60*60*24*10);
                cookie2.setMaxAge(60*60*24*10);

                // 设置cookie路径 凡是这个路径及其子路径都携带这个路径
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());

                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }

            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
