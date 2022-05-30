package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BlogDao;
import dao.UserDao;
import pojo.Blog;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-27
 * Time: 9:41
 */
@WebServlet("/authorInfo")
public class AuthorServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取博客ID参数
         */
        resp.setContentType("application/json; charset=utf-8");
        String blogId = req.getParameter("blogId");
        if (blogId == null || "".equals(blogId)) {
            resp.getWriter().write( "{ \"ok\": false, \"reason\": \"参数缺失!\" }");
            return;
        }
        /**
         * 根据博客ID查询博客
         */
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
        if (blog == null) {
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"要查询的博客不存在!\" }");
            return;
        }

        /**
         * 根据博客中的userID查询用户
         */
        UserDao userDao = new UserDao();
        User author = userDao.selectById(String.valueOf(blog.getUserId()));
        if(author == null) {
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"要查询的用户不存在!\" }");
            return;
        }
        resp.getWriter().write(objectMapper.writeValueAsString(author));
    }
}
