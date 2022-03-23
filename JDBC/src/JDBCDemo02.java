import com.mysql.jdbc.Util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-23
 * Time: 16:51
 */
public class JDBCDemo02 {
    public static void Sql1() {
        DataSource dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setURL("jdbc:mysql://localhost:3306/t1?characterEncoding=utf-8&useSSL=false");
            ((MysqlDataSource)dataSource).setUser("root");
            ((MysqlDataSource)dataSource).setPassword("jsw");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-25 17:50:00");
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-25 17:50:00");

            conn = dataSource.getConnection();
            String sql = "insert into borrow_info(book_id, student_id, start_time, end_time) " +
                    "select b.id, s.id, ?, ? from book b, student s where b.name=? and s.name=?";
            ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(date1.getTime()));
            ps.setTimestamp(2, new Timestamp(date2.getTime()));
            ps.setString(3, "诗经");
            ps.setString(4, "貂蝉");

            int result = ps.executeUpdate();

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Sql2() {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://localhost:3306/t1?characterEncoding=utf-8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("jsw");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();

            String sql = "SELECT bk.NAME book_name,bk.author book_author," +
                    "s.NAME student_name,bi.start_time,bi.end_time" +
                    " FROM borrow_info bi JOIN book bk ON bi.book_id = bk.id" +
                    " JOIN category c ON bk.category_id = c.id" +
                    " JOIN student s ON bi.student_id = s.id" +
                    " WHERE c.NAME = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "计算机");
            rs = ps.executeQuery();
            while(rs.next()){
                String  bookName  = rs.getString("book_name");
                String  bookAuthor = rs.getString("book_author");
                String  studentName = rs.getString("student_name");
                Timestamp startTime  = rs.getTimestamp("start_time");
                Timestamp  endTime   = rs.getTimestamp("end_time");
                System.out.println(String.format("书名：%s，作者：%s，借阅者：%s，" +
                                "借阅起始日期：%s，结束日期：%s",
                        bookName, bookAuthor, studentName, startTime, endTime));
            }

            int result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void Sql3() {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://localhost:3306/t1?characterEncoding=utf-8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("jsw");

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "update book set price=? where name =?";
            ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, new BigDecimal("61.20"));
            ps.setString(2, "深入理解Java虚拟机");

            int result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void Sql4() {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://localhost:3306/t1?characterEncoding=utf-8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("jsw");

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            String sql = "delete from borrow_info where id =" +
                    "(select r.id from (select max(id) id from borrow_info) r)";
            ps = conn.prepareStatement(sql);
            int result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
