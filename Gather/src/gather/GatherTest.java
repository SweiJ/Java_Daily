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
         * Iterable<T> 是一个接口
         *    Collection接口继承Iterable<T>接口
         *    在 Iterable<T> 接口里有一个类型为Ioterator<T>接口的方法ioterator()
         *    ioterator()方法返回类型为T元素的迭代器。
         * Iterator<E> 也是一个接口
         *    通过Ioterator<T>接口中ioterator()方法，返回此迭代器
         *    Iterator<E>接口有forEachRemaining(Consumer<? super E> action)
         *    hasNext() 如果迭代器还有元素，则返回ture
         *    next() 返回迭代器中的下一个元素
         *    remove() 从底层集合中删除此迭代器返回的最后一个元素
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
