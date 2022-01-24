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
 * Time: 10:15
 */
public class JDBCTest03 {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        Properties pro = new Properties();
        pro.load(new FileInputStream("src/jdbc.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        // 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        // 定义sql语句
        String sql = "select * from salgrade;";

        // 执行sql语句
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ResultSet rs = ptmt.executeQuery();

        Salgrade salgrade = null;
        List<Salgrade> list = new ArrayList<>();
        while(rs.next()) {
            // 获取值
            int grade = rs.getInt("grade");
            double losal = rs.getDouble("losal");
            double hisal = rs.getDouble("hisal");

            // 封装成对象
            salgrade = new Salgrade();
            salgrade.setGrade(grade);
            salgrade.setHisal(hisal);
            salgrade.setLasal(losal);

            // 添加到集合
            list.add(salgrade);
        }

        System.out.println(list);
        // 释放
        rs.close();
        ptmt.close();
        conn.close();
    }
}
