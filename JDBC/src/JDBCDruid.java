import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-10
 * Time: 21:45
 */
public class JDBCDruid {
    public static void main(String[] args) throws Exception {

        // 加载配置文件
        Properties pro = new Properties();
        pro.load(new FileInputStream("src/jdbc.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        // 获取数据库连接 Connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        System.out.println(System.getProperty("user.dir"));
    }
}
