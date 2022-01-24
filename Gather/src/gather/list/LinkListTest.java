package gather.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-28
 * Time: 16:20
 */
public class LinkListTest {
    public static void main(String[] args) {
        /**
         * ������ ����˫���������Դ洢�ڷ�ɢ���ڴ��У�ÿ����һ��Ԫ�ؾ���Ҫһ��node����
         * �ʺ������ݲ����ɾ����������������iterator��������forѭ��ע�����
         * ��ʹ��forѭ��������ͨ��get(i)ȡ�õ�ÿһ��Ԫ�ض���Ҫ��list���½��б���
         * �����̰߳�ȫ��
         */
        List<String> list = new LinkedList<>();
        list.add("xiao");
        list.add("wei");
        list.add("jia");

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(list.get(2));
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
        }
    }
}
