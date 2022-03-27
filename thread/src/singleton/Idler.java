package singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-27
 * Time: 9:41
 */

import java.util.IdentityHashMap;

/**
 * ʵ�ֵ���ģʽ ����ģʽ
 * @author SweiPC
 */
public class Idler {
    /**
     *  ����ʱ���������� volatile��֤�ڴ�ɼ���
     */
    private volatile static Idler instance = null;

    /**
     *  ��Ϊ˽��
     */
    private Idler() {
    }

    /**
     * ����Ҫ����ʱ�Ŵ�������
     * ��ʱ����д������̲߳���ȫ����
     * ��Ҫ��synchronized
     * @return
     */
    public static Idler getInstance() {
        if(instance == null) {
            synchronized (Idler.class) {
                if (instance == null) {
                    instance = new Idler();
                }
            }
        }
        return instance;
    }
}
