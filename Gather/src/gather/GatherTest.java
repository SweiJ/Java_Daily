package gather;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-28
 * Time: 10:38
 */
public class GatherTest {
    public static void main(String[] args) {
        Collection<String> arr1 = new ArrayList<>();
        arr1.add("xiaojiang");
        arr1.add("xiaoming");
        arr1.add("honghong");

        /**
         * Iterable<T> ��һ���ӿ�
         *    Collection�ӿڼ̳�Iterable<T>�ӿ�
         *    �� Iterable<T> �ӿ�����һ������ΪIoterator<T>�ӿڵķ���ioterator()
         *    ioterator()������������ΪTԪ�صĵ�������
         * Iterator<E> Ҳ��һ���ӿ�
         *    ͨ��Ioterator<T>�ӿ���ioterator()���������ش˵�����
         *    Iterator<E>�ӿ���forEachRemaining(Consumer<? super E> action)
         *    hasNext() �������������Ԫ�أ��򷵻�ture
         *    next() ���ص������е���һ��Ԫ��
         *    remove() �ӵײ㼯����ɾ���˵��������ص����һ��Ԫ��
         */
        Iterator<String> it = arr1.iterator();
//        for ( String x: it ) {
//            System.out.println(it);
//        }
        System.out.println(it);
        while(it.hasNext()) {
            it.remove();
            System.out.println(it.next());
        }
    }
}
