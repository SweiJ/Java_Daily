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
         * 链表集合 基于双向链表，可以存储在分散的内存中，每增加一个元素就需要一个node对象
         * 适合做数据插入和删除操作，链表能用iterator迭代器和for循环注意遍历
         * 当使用for循环遍历，通过get(i)取得的每一个元素都需要对list重新进行遍历
         * 不是线程安全的
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
