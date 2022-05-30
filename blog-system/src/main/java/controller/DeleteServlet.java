package controller;

import dao.BlogDao;
import pojo.Blog;

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
 * Date: 2022-05-28
 * Time: 9:17
 */
@WebServlet("/blogDelete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取博客ID参数
         */
        String blogId = req.getParameter("blogId");
        if(blogId == null || "".equals(blogId)) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("当前参数不正确!");
            return;
        }

        /**
         * 查询博客
         */
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
        if(blog == null) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("当前要删除的博客不正确!");
            return;
        }

        /**
         * 删除博客
         */
        blogDao.delete(Integer.parseInt(blogId));
        resp.sendRedirect("blog_list.html");
    }
}
