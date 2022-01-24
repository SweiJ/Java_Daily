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
         * 两种方式初始化数组列表。
         * 不指定容量情况下（源代码会初始一个空的数组，当添加第一个元素的时候，容量才会变成10）
         * 当超出容量值时，扩容原来容量的1.5倍
         * ArrayList集合底层是Object类型的数组Obiect[]
         * 建议给定一个初始化容量，减少数组的扩容次数
         * 数组的优点：
         *      检索效率比较高（每个元素占用空间大小相同，内存地址是连续的，知道首元素内存地址）
         * 数组的缺点：
         *      增删元素效率比较低
         * 不是线程安全的
         */
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>(20);
        list1.add("效果");

        // 构建一个包含指定集合元素的列表，根据它们在集合的迭代器返回的顺序存储
        Collection<String> c = new HashSet<>();
        c.add("小姜");
        c.add("小红");
        c.add("小李");
        List<String> list3 = new ArrayList<>(c);
        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }
    }
}
