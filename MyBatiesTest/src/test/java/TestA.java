import com.Swei.mapper.DeptMapper;
import com.Swei.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

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
        //List<com.Swei.pojo.Dept> list = sqlSession.selectList("deptmapper.selectAll");

        // 返回一条结果
        //com.Swei.pojo.Dept dept = sqlSession.selectOne("deptmapper.selectOne");

        // 返回map类型
        //Map<Object, Object> id = sqlSession.selectMap("deptmapper.selectMap", "deptno");

        // 查询操作
//        DeptMapper dm = sqlSession.getMapper(DeptMapper.class);
//        List<Dept> dept = dm.selectAll();
//        System.out.println(dept);

        // 插入操作
        DeptMapper dm = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(50, "SWEI", "HENAN");
        System.out.println(dm.insert(dept));

        // 关闭资源
        sqlSession.close();
    }
}
