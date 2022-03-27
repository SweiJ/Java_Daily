package singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-27
 * Time: 9:39
 */

/**
 * ʵ�ֵ���ģʽ ����ģʽ
 * @author SweiPC
 */
public class Hungry {
    /**
     * instance ��ӦΨһʵ�� ����ʱ��������
     */
    private static Hungry instance = new Hungry();

    /**
     * Ϊ�˷�ֹ�� new ���� ��Ϊ˽��
     */
    private Hungry() {
    }

    /**
     * �������Ψһʵ��
     * @return
     */
    public static Hungry getInstance() {
        return instance;
    }
}
