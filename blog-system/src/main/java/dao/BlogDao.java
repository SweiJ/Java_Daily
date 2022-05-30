package dao;

import pojo.Blog;
import util.DButil;

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
 * Date: 2022-05-23
 * Time: 20:19
 */
public class BlogDao {
    /**
     * 插入博客
     * @param blog
     */
    public void insert(Blog blog) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "insert into blog values(null, ?, ?, ?, now())";
            statement = connection.prepareStatement(sql);

            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(connection, statement, resultSet);
        }
    }

    /**
     * 查询所有博客
     * @return
     */
    public List<Blog> selectAll() {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                String content = resultSet.getString("content");
                if(content.length() > 50) {
                    content = content.substring(0, 50) + "...";
                }
                blog.setContent(content);
                blog.setUserId(resultSet.getShort("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(connection, statement, resultSet);
        }
        return blogs;
    }

    /**
     * 查询一个博客
     * @return
     */
    public Blog selectOne(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);

            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getShort("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(connection, statement, resultSet);
        }
        return null;
    }

    /**
     * 删除博客
     * @param blogId
     */
    public void delete(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.close(connection, statement, resultSet);
        }
    }
}
