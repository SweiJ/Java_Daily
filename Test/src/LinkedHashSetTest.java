import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-04
 * Time: 20:49
 */
@SuppressWarnings({"all"})
public class LinkedHashSetTest {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("xiaoming");
        hashSet.add("xiaoming");
        hashSet.add("xiaoli");
        hashSet.add("xiaohong");
        Hashtable hashtable = new Hashtable();
    }
    public static void main4(String[] args) {
//        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i < 10; i++) {
//            arrayList.add(i);
//        }
        LinkedList linkedList = new LinkedList();
        linkedList.add("xiaoming");
        linkedList.add("xiaoming");
        linkedList.add("xiaoming");

    }
    public static void main3(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("xiaoming");
        list.add("xiaohong");
        list.add("xiaoli");
        list.add("xiaosi");
        // 通过Iterator 迭代
        Iterator io = list.iterator();
        while(io.hasNext()) {
            System.out.println(io.next());
        }
        // 通过增强for循环遍历
        for (String x : list) {
            System.out.println(x);
        }
    }
    public static void main1(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("xiaojiang");
        linkedHashSet.add("xiaowei");
        linkedHashSet.add("wei");
        System.out.println(linkedHashSet);
    }
    public static void main2(String[] args) {
//        HashSet hashSet = new HashSet();
//        hashSet.add("xiaojiang");
//        hashSet.add("xiaojian");
//        hashSet.add("xiaojiag");
//        hashSet.add("xiaojng");
//        hashSet.add("xijiang");
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        treeMap.put("123","xaiojiang");
        treeMap.put("244","xaiojian");
        treeMap.put("24433","xaio");
        treeMap.put("3","xaioji");

        System.out.println(treeMap);
    }

}
