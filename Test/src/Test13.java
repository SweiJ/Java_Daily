import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 11:21
 */
public class Test13 {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();
        // 可以是任何类型
        fun(list1);
        fun(list2);
        fun(list3);
        fun(list4);
        fun(list5);
        // 只能是AA或AA的子类
//        fun1(list1);
//        fun1(list2);
        fun1(list3);
        fun1(list4);
        fun1(list5);
        // 只能是AA或AA的父类
        fun2(list1);
//        fun2(list2);
//        fun2(list3);
//        fun2(list4);
//        fun2(list5);
    }

    public static void fun(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
    // 可以接收AA和AA的子类
    public static void fun1(List<? extends AA> list) {
        for (AA aa : list) {
            System.out.println(aa);
        }
    }

    // 支持AA和AA的父类
    public static void fun2(List<? super AA> list) {

    }

}
class AA{

}
class BB extends AA {

}
class CC extends BB {

}
