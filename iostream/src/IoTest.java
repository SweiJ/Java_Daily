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
     * �ļ���ɾ���ʹ���
     * new fileֻ��һ������ֻ��createNewFile�Ż���������һ���ļ�
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("c://test.txt");
        if(file.exists()) {
            System.out.println("�ļ�ɾ��" + file.delete());
        } else {
            System.out.println("�ļ�����" + file.createNewFile());
        }

        File file1 = new File("c://");
        String path = "test1.txt";
        File file2 = new File(file1,path);
        if(file2.exists()) {
            System.out.println("�ļ�ɾ��" + file2.delete());
        } else {
            System.out.println("�ļ�����" + file2.createNewFile());
        }
    }
}
