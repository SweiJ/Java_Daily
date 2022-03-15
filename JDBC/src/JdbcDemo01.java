import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-15
 * Time: 20:04
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://localhost:3306/t1?characterEncoding=utf-8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("jsw");
        Connection connection = dataSource.getConnection();
        String sql = "insert into student01 values('zhang', 22)";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int i = statement.executeUpdate();
        System.out.println(i);

        resultSet.close();
        statement.close();
    }
}
