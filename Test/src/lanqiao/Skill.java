package lanqiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-02-10
 * Time: 16:57
 */
public class Skill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] temp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }
        temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap();;
        while(sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.put(x, y);
        }
        int max = arr[1];
        for (int i = 2; i < n + 1; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
    }
}
class ListT {
    static int k, ans;
    static int[] arr1 = new int[100];
    static boolean[] vis = new boolean[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        dfs(1);
        System.out.println(ans);
    }

    /**
     * 判断当前序列个数
     * @param num 当前数值
     * @param x 序列个数
     * @return
     */
    static boolean fun(int num, int x) {
        if(x == 1 || x == 2) {
            return true;
        }
        if((arr1[x - 1] - arr1[x - 2]) * (num - arr1[x - 2]) < 0) {  // 如果第i-1个比i-2个大则第i个比第i-2小
            return true;
        }
        return false;
    }
    static void dfs(int x) {
        if(x > k) { // 当前的值大于输入值时
            return;
        }
        for (int i = 1; i <= k; i++) { // 在值范围内
            if(!vis[i] && fun(i, x)) {
                vis[i] = true;
                arr1[x] = i;
                if(x >= 2)
                    ans++;
                dfs(x + 1);
                vis[i] = false;
            }
        }
    }
}
