import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-16
 * Time: 11:05
 */
public class IoTest {

    public static void main1(String[] args) {

    }
    /**
     * 文件的删除和创建
     * new file只是一个对象，只有createNewFile才会真正创建一个文件
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("c://test.txt");
        if(file.exists()) {
            System.out.println("文件删除" + file.delete());
        } else {
            System.out.println("文件创建" + file.createNewFile());
        }

        File file1 = new File("c://");
        String path = "test1.txt";
        File file2 = new File(file1,path);
        if(file2.exists()) {
            System.out.println("文件删除" + file2.delete());
        } else {
            System.out.println("文件创建" + file2.createNewFile());
        }
    }
}
