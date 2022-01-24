import javax.rmi.CORBA.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-22
 * Time: 15:03
 */
public class Test19 {
    static void fun(int[] arr, int k) {
        if(k == 1) {
            return;
        }
        fun(arr, k - 1);

        int target = arr[k];
        int j = k;
        while (j > 0 && target < arr[j - 1])
        {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = target;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,27,35,25,25,2,6,6,7};
//        int i, j;
//        int n = arr.length;
//        int target;

        fun(arr, arr.length - 1);
        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
//        for (i = 1; i < n; i++)
//        {
//            j = i;
//            target = arr[i];
//
//            while (j > 0 && target < arr[j - 1])
//            {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//
//            arr[j] = target;
//        }
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
    }
    /**
     * 数组中只有一个数出现一次，其他数出现k次，找出出现一次的数
     *     1.相同的数做不进位加法
     *     2.2个相同的二进制做不进位加法得0
     *     3.10个相同的十进制做不进位加法得0
     *     4.k个相同的k进制做不进位加法得0
     *  思路：
     *      1、首先将数组中的元素化成k进制通过使用（Integer.toString(i, radix);
     *      2、将这些数做不进位加法最后的结果为出现一次的数。
     */
    public static void main6(String[] args) {
        // 10转换成3进制
        System.out.println(Integer.toString(10, 3));
//        int[] arr = {1,1,1,3,3,3,4,4,4,7,8,8,8};
//        Map map = new HashMap();
//        for (int i = 0; i < arr.length; i++) {
//            if(map.get(arr[i]))
//            map.put(arr[i], 0);
//
//        }
    }
    // 二进制小数
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double n = scanner.nextDouble();
        StringBuilder sb = new StringBuilder("0.");
        while(n > 0) {
            double r = n*2;
            if(r >= 1) {
                // 消除整数部分
                sb.append("1");
                n = r - 1;
            } else {
                sb.append("0");
                n = r;
            }
            if(sb.length() > 34) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb);
    }
    // 二进制奇偶位互换
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 取出偶数位
        int even = n&0xaaaaaaaa;
        // 取出奇数位
        int old = n&0x55555555;
        // 偶数位右移 奇数位左移
        int result = (even>>1)^(old<<1);
        System.out.println(result);
    }
    // 当前数是否是2的整数次方
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if((n^(n-1)) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    // 二进制中含有多少个1
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while(n != 0) {
            n &= (n-1);
            count++;
        }
        System.out.println(count);
    }
    // 1-1000之中有一个重复的数，找出这个数。
    public static void main1(String[] args) {
        int n = 1001;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i+1;
        }
        arr[arr.length - 1] = new Random().nextInt(n);

        int x = 0;
        for (int i = 1; i < n; i++) {
            x ^= i;
        }
        for (int i = 0; i < n; i++) {
            x ^= arr[i];
        }
        System.out.println(x);
    }
}
