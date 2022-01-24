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
         * 底层也是一个数组
         * 初始容量为：10 扩容之后的容量是原容量的2倍
         * ArrayList扩容之后的容量是原来的1.5倍
         * Vector中所有的方法都是线程同步的，都带有synchronize关键字
         * 是线程安全的 （效率较低）
         *
         * 将线程不安全的ArrayList集合转换成线程安全的
         *  使用集合工具类：
         *      java.util.Collections; 这个是集合工具类
         *      java.util.Collection;  这个是集合接口
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
        // 线程安全的
        Collections.synchronizedList(myList);
        myList.add("111");
        myList.add("112");
        myList.add("113");
    }
}
