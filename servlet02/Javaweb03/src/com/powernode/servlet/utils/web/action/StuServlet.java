package com.powernode.servlet.utils.web.action;

import com.powernode.servlet.utils.DBUtil;
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
 * Date: 2022-03-06
 * Time: 15:01
 */
public class StuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String stu_name = request.getParameter("stu_name");
        String age = request.getParameter("age");
        String aClass = request.getParameter("class");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into student values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stu_name);
            ps.setString(2, age);
            ps.setString(3, aClass);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        if(count == 1) {
            // 转发形式 向表中插入数据的时候每刷新一次请求 刷新一次不会转到/success.html 会插入一次
            request.getRequestDispatcher("/success.html").forward(request,response);

            // 重定向 转到/success.html页面 刷新请求不会重新插入
//            response.sendRedirect(""+request.getContextPath()+"/success.html");
        }
    }
}
