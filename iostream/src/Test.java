/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-17
 * Time: 23:05
 */
public class Test {
    public static void main(String[] args) {
        shengdanshu();
    }
    public static void shengdanshu(){
        //Ҷ�Ӳ�
        int level = 10;
        //����
        int rootLevel = 2;
        int spaceNum = level - 1;

        //��Ҷ��
        // Ϊʲô��1��ʼ  �����˾�������
        for (int i = 1; i <= level; i++) {
            spaceNum--;
            for (int g = 0; g <= spaceNum; g++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i * 2) -1); j++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
        System.out.println("  ?ʥ���ڿ���?");
        //����
        for (int i = 1; i <= rootLevel; i++) {
            for (int g = 1; g < level; g++) {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }

    }
}
