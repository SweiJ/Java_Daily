import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-20
 * Time: 10:20
 */
public class TestA {

    public static void main(String[] args) throws IOException {

        // 解析mabaties文件
        InputStream inputStream = Resources.getResourceAsStream("mybaties.xml");

        // 获得sqlsession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行方法
        // 返回多条结果
        //List<Dept> list = sqlSession.selectList("deptmapper.selectAll");

        // 返回一条结果
        //Dept dept = sqlSession.selectOne("deptmapper.selectOne");

        // 返回map类型
        Map<Object, Object> id = sqlSession.selectMap("deptmapper.selectMap", "deptno");

        System.out.println(id);

        // 关闭资源
        sqlSession.close();
    }
}
