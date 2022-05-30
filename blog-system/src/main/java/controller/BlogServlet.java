package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BlogDao;
import pojo.Blog;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-23
 * Time: 21:09
 */
@WebServlet("/blogs")
public class BlogServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 用来获取数据库中的博客列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 可以根据博客ID获取博客或者获取全部博客
         */
        String param = req.getParameter("blogId");
        resp.setContentType("application/json; charset=utf-8");
        BlogDao blogDao = new BlogDao();
        /**
         * 如果没有参数则获取全部博客
         * 如果有参数则获取某个博客ID的博客
         */
        if (param == null) {
            List<Blog> blogs = blogDao.selectAll();
            // 把blogs转换成json格式
            String respJson = objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(respJson);
        } else {
            int blogId = Integer.parseInt(param);
            Blog blog = blogDao.selectOne(blogId);
            String respJson = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(respJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        /**
         * 如果session为空证明用户未登录
         */
        if (user == null) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("当前用户未登录, 不能提交博客!");
            return;
        }

        /**
         * 获取请求的参数
         */
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || "".equals(title) || content == null || "".equals(content)) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("提交博客失败, 缺少必要参数!");
            return;
        }

        /**
         * 如果有参数封装成对象
         */
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserId(user.getUserId());

        /**
         * 添加博客到数据库
         */
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);

        resp.sendRedirect("blog_list.html");
    }
}
