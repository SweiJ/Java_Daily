/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 9:51
 */
public class ThreadTest {
    /**
     * �������̵߳���ģ��
     * ��ռʽ����ģ�ͣ�
     *      �ĸ��̵߳����ȼ��Ƚϸߣ�������CPUʱ��Ƭ�ĸ��ʾ͸�һЩ
     *      java���õľ�����ռʽ����ģ��
     * ����ʽ����ģ�ͣ�
     *      ƽ������CPUʱ��Ƭ��ÿ���߳�ռ�е�CPUʱ��Ƭʱ�䳤��һ��
     *      ƽ�����䣬һ��ƽ��
     * @param args
     */
    public static void main(String[] args) {
        // main������ ����Ĵ����������߳� ����ջ������
        // �½�һ����֧�̶߳���
        T t = new T();
        // ����ʹ��t.run()�����������̣߳�run()�����½�һ���µ��߳�

        // �����߳� ����һ���µ�ջ�ռ䣬ֻҪ�µ�ջ�ռ俪�����ˣ�start()����Ҳ�ͽ�����
        // t.start()ֻ�ǿ����߳�ջ�ռ䡣�����run()��������ʱrun()���ڷ�֧�߳����ջ��ѹջ
        // run()��main()����ͬһ�����𣬶�����ջ����ײ�
        t.start();
    }
}
class T extends Thread {
    @Override
    public void run() {
        T1 t1 = new T1(10);
        System.out.println(t1.toString());
        System.out.println("��ִ���ˣ�");
    }
}
class T1 {
    private int age;

    public T1(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "T1{" +
                "age=" + age +
                '}';
    }
}