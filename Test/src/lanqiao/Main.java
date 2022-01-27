package lanqiao;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-23
 * Time: 18:34
 */
public class Main {
    // 数字游戏
    public static void main(String[] args) throws IOException {
        File file;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        Boolean[] arr1 = new Boolean[n + 1];
        for (int i = 0; i < n + 1; i++)
            arr1[i] = false;
        List<Integer> list = new ArrayList<>();
        numGame(list, arr1,1, n,m);
    }
    private static void numGame(List<Integer> list, Boolean[] arr1, int step, int n, int m) {
        if(step > n) {
            if (compare(list, n, m)) {
                System.exit(0);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!arr1[i]) {
                arr1[i] = true;
                list.add(i);
                numGame(list, arr1,step + 1, n, m);
                arr1[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    private static Boolean compare(List<Integer> list, int n, int m) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                arr[j] += arr[j + 1];
            }
        }
        if(arr[0] == m) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            return true;
        }
        return false;
    }
}
