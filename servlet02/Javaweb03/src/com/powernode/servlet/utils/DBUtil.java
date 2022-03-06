package com.powernode.servlet.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-05
 * Time: 12:25
 */
public class DBUtil {
    // 属性资源绑定
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");
    static {
        // 注册驱动 DBUtil类加载的时候执行
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return conn
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 释放资源
     * @param conn 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果对象
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
