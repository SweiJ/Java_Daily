import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-02-19
 * Time: 11:44
 */
public class Test20 {
    //key是关键字  value是出现的次数
    public static Map<Integer,Integer> func1(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        //判断array中的元素 是否在map当中，如果不在就是1.在就是在原来的基础上+1
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        return map;
    }
    public static Set<Integer> func2(int[] array) {
        Set<Integer> entries = new HashSet<>();
        int x = 0;
        //判断array中的元素 是否在map当中，如果不在就是1.在就是在原来的基础上+1
        for (int i = 0; i < array.length; i++) {
            if(entries.contains(array[i])) {
                x = array[i];
            }
            entries.add(array[i]);
        }
        return entries;
    }
    public static void main(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        Map<Integer,Integer> map = func1(array);
        System.out.println(map);
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if(set.contains(num)) {
               set.remove(num);
            } else  {
                set.add(num);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        Integer next = iterator.next();
        return next;
    }
}
