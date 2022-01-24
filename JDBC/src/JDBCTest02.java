import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-10
 * Time: 20:55
 */
public class JDBCTest02 {
    public static void main1(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/t1";
        String user = "root";
        String password = "jsw";
        Connection connection = DriverManager.getConnection(url, user, password);

        String id = "1";
        String name = "' or '1' = '1";
        // 定义sql
        String sql = "select * from stu where id = '" + id + "' and name = '" + name + "'";
        System.out.println(sql);

        // 获取执行sql的对象 Statement
        Statement stmt = connection.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        // 释放资源
        rs.close();
        stmt.close();
        connection.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/t1";
        String user = "root";
        String password = "jsw";
        Connection connection = DriverManager.getConnection(url, user, password);

        String id = "1";
        String name = "' or '1' = '1";
        // 定义sql
        String sql = "select * from stu where id = ? and name = ?";
        System.out.println(sql);

        // 获取执行sql的对象 Statement
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1,id);
        pstmt.setString(2,name);

        // 执行sql
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        // 释放资源
        rs.close();
        pstmt.close();
        connection.close();
    }
}
