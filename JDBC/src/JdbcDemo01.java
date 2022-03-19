import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-15
 * Time: 20:04
 */
public class JdbcDemo01 {
    public static void main1(String[] args) throws SQLException, ClassNotFoundException {
        // 不需要此代码
//        Class.forName("java.sql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1?characterEncoding=utf-8&useSSL=false");

    }
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://localhost:3306/t1?characterEncoding=utf-8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("jsw");

        Connection connection = dataSource.getConnection();
        String sql = "select * from student01 where id = ?";
//        String sql = "insert into student01 values('zhang', 22)";
        Statement statement1 = connection.createStatement();
//        int i1 = statement1.executeUpdate(sql);
        boolean execute = statement1.execute(sql);
//        ResultSet resultSet1 = statement1.executeQuery(sql);

        Savepoint savepoint = connection.setSavepoint();

        CallableStatement callableStatement = connection.prepareCall(sql);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "2");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            System.out.println(name + " " + age);
        }
        int i = statement.executeUpdate();
        System.out.println(i);

        resultSet.close();
        statement1.close();
        connection.rollback(savepoint);
    }
}
