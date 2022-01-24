import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-11
 * Time: 10:38
 */
public class JDBCTest04 {
    public static void main(String[] args) throws Exception {
        // 模拟提交数据
        int grade = 6;
        double losal = 5000.00;
        double hisal = 3333.01;

        // 加载配置文件
        Properties pro = new Properties();
        pro.load(new FileInputStream("src/jdbc.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        // 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        // 定义sql语句
        String sql = "insert into salgrade values(?, ?, ?)";

        // 执行sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,grade);
        ptmt.setDouble(2,losal);
        ptmt.setDouble(3,hisal);

        int count = ptmt.executeUpdate(); // 影响的行数

        System.out.println(count > 0);

        // 释放
        ptmt.close();
        conn.close();
    }
}
