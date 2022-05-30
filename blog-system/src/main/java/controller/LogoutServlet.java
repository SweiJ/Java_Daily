package controller;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-27
 * Time: 19:33
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 退出登陆 清空session中的值
         */
        HttpSession session = req.getSession();
        if(session == null) {
            resp.getWriter().write("当前用户尚未登录, 无法注销!");
            return;
        }

        session.removeAttribute("user");
        resp.sendRedirect("login.html");
    }
}
