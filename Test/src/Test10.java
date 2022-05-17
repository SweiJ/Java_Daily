import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-05
 * Time: 22:15
 */
@SuppressWarnings("all")
public class Test10 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("ja ck", 650);
        hashMap.put("to m", 1200);
        hashMap.put("smith", 2900);
        hashMap.replace("jack",650,2600);

        Set<String> strings = hashMap.keySet();

        for (String s : hashMap.keySet()) {
            hashMap.put(s, hashMap.get(s) + 100);
            System.out.println(s);
        }
        for (Integer value : hashMap.values()) {
            System.out.println(value);
        }
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

    }
}
