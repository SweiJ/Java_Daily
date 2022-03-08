package com.powernode.oa.web.action;

import com.powernode.oa.obj.Dept;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-06
 * Time: 17:51
 */
//@WebServlet({"/dept/list","/dept/detail","/dept/delete","/dept/add","/dept/edit","/dept/modify"})
//@WebServlet("/dept/*")
@WebServlet({"/dept/list","/dept/detail","/dept/delete","/dept/add","/dept/edit","/dept/modify"})
public class DeptServelt extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取当前servlet请求的路径
        String servletPath = request.getServletPath();
        // 当前session没有创建时 也不用创建
        HttpSession session = request.getSession(false);
        // 当session不为空也就是访问了UserServlet 并且登陆成功
        if(session != null && session.getAttribute("username") != null) {
            if ("/dept/list".equals(servletPath)) {
                doList(request, response);
            } else if ("/dept/detail".equals(servletPath)) {
                doDetail(request, response);
            } else if ("/dept/delete".equals(servletPath)) {
                doDel(request, response);
            } else if ("/dept/add".equals(servletPath)) {
                doAdd(request, response);
            } else if ("/dept/modify".equals(servletPath)) {
                doModify(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() +"/index.jsp");
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 保存数据库中的各个列的数据
        List<Dept> depts = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                Dept dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);

                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }

        // 将数据库中的数据绑定到request请求域中 然后转发
        request.setAttribute("deptList", depts);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求数据deptno
        String deptno = request.getParameter("deptno");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Dept dept = new Dept();
        try {
            conn = DBUtil.getConnection();
            String sql = "select dname, loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            while(rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }

        request.setAttribute("dept", dept);
        String forward = "/"+request.getParameter("f")+".jsp";
        request.getRequestDispatcher(forward).forward(request,response);
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        // 获取根路径
        String contextPath = request.getContextPath();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        if(count == 1) {
            response.sendRedirect(contextPath +"/dept/list");
        } else {
            response.sendRedirect(contextPath +"/error.jsp");
        }
    }
    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取根路径
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into dept values(?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        if(count == 1) {
            response.sendRedirect(contextPath +"/dept/list");
        } else {
            response.sendRedirect(contextPath +"/error.jsp");
        }
    }
    private void doModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取根路径
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "update dept set dname=?, loc=? where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setString(2, loc);
            ps.setString(3, deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        if(count == 1) {
            response.sendRedirect(contextPath+"/dept/list");
        } else {
            response.sendRedirect(contextPath+"/error.jsp");
        }
    }
}

