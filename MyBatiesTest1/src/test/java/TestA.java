import com.sweij.mapper.DeptMapper;
import com.sweij.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = mapper.selectMore(10,"");
        System.out.println(list);
        // 关闭资源
        sqlSession.close();
    }
}
