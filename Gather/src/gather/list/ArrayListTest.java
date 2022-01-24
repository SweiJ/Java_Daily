package gather.list;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-28
 * Time: 13:41
 */
public class ArrayListTest {
    public static void main(String[] args) {
        /**
         * ���ַ�ʽ��ʼ�������б�
         * ��ָ����������£�Դ������ʼһ���յ����飬����ӵ�һ��Ԫ�ص�ʱ�������Ż���10��
         * ����������ֵʱ������ԭ��������1.5��
         * ArrayList���ϵײ���Object���͵�����Obiect[]
         * �������һ����ʼ��������������������ݴ���
         * ������ŵ㣺
         *      ����Ч�ʱȽϸߣ�ÿ��Ԫ��ռ�ÿռ��С��ͬ���ڴ��ַ�������ģ�֪����Ԫ���ڴ��ַ��
         * �����ȱ�㣺
         *      ��ɾԪ��Ч�ʱȽϵ�
         * �����̰߳�ȫ��
         */
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>(20);
        list1.add("Ч��");

        // ����һ������ָ������Ԫ�ص��б����������ڼ��ϵĵ��������ص�˳��洢
        Collection<String> c = new HashSet<>();
        c.add("С��");
        c.add("С��");
        c.add("С��");
        List<String> list3 = new ArrayList<>(c);
        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }
    }
}
