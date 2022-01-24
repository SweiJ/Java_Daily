package gather.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-28
 * Time: 13:16
 */
public class ListTest {
    public static void main(String[] args) {
        /**
         * List是一个有序集合,可以包含重复的元素。可以从其索引访问任何元素。
         * List更像是具有动态长度的数组。列表是最常用的集合类型之一。
         * ArrayList和LinkedList是List接口的实现类
         */
        List<String> list = new ArrayList<>();
        list.add("xiao");
        list.add("jiang");
        list.add("hong");

        // 在下标1处增加元素 此方法效率太慢
        list.add(1,"wei");

        // 修改0下标为xia
        list.set(0, "xia");

        // 删除列表元素或者下标
        list.remove("jiang");
        list.remove(2);

        String name = "xiao";
        // 用迭代器遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("===================");
        // 利用下标遍历
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
        }
        System.out.println(list.contains(name));
    }
}
