package gather.list;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-28
 * Time: 17:01
 */
public class VectorTest {
    public static void main(String[] args) {
        /**
         * �ײ�Ҳ��һ������
         * ��ʼ����Ϊ��10 ����֮���������ԭ������2��
         * ArrayList����֮���������ԭ����1.5��
         * Vector�����еķ��������߳�ͬ���ģ�������synchronize�ؼ���
         * ���̰߳�ȫ�� ��Ч�ʽϵͣ�
         *
         * ���̲߳���ȫ��ArrayList����ת�����̰߳�ȫ��
         *  ʹ�ü��Ϲ����ࣺ
         *      java.util.Collections; ����Ǽ��Ϲ�����
         *      java.util.Collection;  ����Ǽ��Ͻӿ�
         */
        List<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);

        Iterator<Integer> it = vector.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        List<String> myList = new ArrayList<>();
        // �̰߳�ȫ��
        Collections.synchronizedList(myList);
        myList.add("111");
        myList.add("112");
        myList.add("113");
    }
}
