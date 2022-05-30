package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
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
 * Date: 2022-05-24
 * Time: 20:35
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 前端提交的用户名和密码
         */
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null || "".equals(username) || password == null || "".equals(password)) {
            resp.getWriter().write("当前用户名或密码为空!");
            return;
        }

        /**
         * 数据库校验
         */
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(username);
        if(user == null || !user.getPassword().equals(password)) {
            resp.getWriter().write("用户名或密码错误!");
            return;
        }

        /**
         * 建立会话
         */
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);

        /**
         * 重定向
         */
        resp.sendRedirect("blog_list.html");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取session中的值 如果为空则返回空的json格式
         * 如果不为空 则返回user信息 且密码为空
         */
        resp.setContentType("application/json; charset=utf-8");
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }

        user.setPassword("");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
