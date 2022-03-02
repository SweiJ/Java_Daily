import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-02-27
 * Time: 15:18
 */
public class Test22 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("atsdgsdg");
        int m = 3;
        System.out.println(sb);
    }
    public static void main3(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str = "java";
        // 将字符串添加"xiao"字符串
        sb.append("xiao");
        // 将sb字符串中第 [0, 2) 位字符替换为str -- javaao
        sb.replace(0, 2, str);
        // 删除第 [3, 5) 为字符                -- javo
        sb.delete(3, 5);
        // 返回字符串的长度                     -- 4
        System.out.println(sb.length());
        // 返回指定下标的值                     -- j
        System.out.println(sb.charAt(0));
        // 返回下标为 [0, 3) 之间的子序列        -- jav
        System.out.println(sb.substring(0, 3));
        System.out.println(sb);
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fib = new int[1000000 + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int i = 0;
        while(fib[i++] < n) {
        }
        int x = Math.min(Math.abs(fib[i - 1] - n), Math.abs(fib[i - 2] - n));
        System.out.println(x);
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();
            String[] t = str.split(" ");
            for (int i = 0; i < t.length; i++) {
                set.add(t[i]);
            }
        }
        System.out.println(set.size());
    }
}
