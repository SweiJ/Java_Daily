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
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String numStr = bf.readLine();

        String[] num = {"ling ", "yi ", "er ", "san ", "si ", "wu ", "liu ", "qi ", "ba ", "jiu "};
        String[] wei = {"", "shi ", "bai ", "qian ", "wan ", "shi ", "bai ", "qian ", "yi ", "shi ", "bai "};
        StringBuilder read = new StringBuilder();
        int len = numStr.length();
        // 0的判断
        boolean b = true;
        int i, j;

        for (i = 0; i < numStr.length(); i++) {
            // 第i位置的数字
            for (j = 0; j <= 9; j++)
                if (numStr.charAt(i) == j + '0')
                    break;
            // 数值位1的数处于当前数的最高位 也就是十亿位 or 十万位 or 十位
            if ((numStr.length() + 2) % 4 == 0 && i == 0 && j == 1) {
                read.append(wei[len- 1]);
            // 判断当前数的位置如果不是最低位， 并且该数为0 也就是0的位置在中间
            } else if (i != len - 1 && j == 0) {
                // 判断如果连续存在两个0时，只增加一个ling
                if (b) {
                    read.append(num[j]);
                    b = false;
                }
            // 如果最后一位的值为0
            } else if (i == len - 1 && j == 0) {
                // 如果最后一位前面也是0， 则删除前面的数
                if (!b)
                    read.append(read.substring(0, read.length() - 5));
                // ling
            } else {
                read.append(num[j] + wei[numStr.length() - i - 1]);
                b = true;
            }
        }
        System.out.println(read);
    }
    public static void main5(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] arr = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu","shi","bai","qian","wan","yi"};
        int len = str.length();
        switch (len) {
            case 0 :
                System.out.println(" ");
                break;
            case 1 :
                System.out.println(arr[Integer.parseInt(str)]);
                break;
            case 2 :
                if(str.charAt(1) == '0') {

                    System.out.println(arr[Integer.valueOf(str.charAt(0))] + "shi");
                } else {
                    System.out.println(arr[Integer.valueOf(str.charAt(0))] + "shi" + arr[Integer.valueOf(str.charAt(1))]);
                }
                break;
            case 3 :
            case 4 :
            case 5 :
            case 6 :
            case 7 :
            case 8 :
            case 9 :
            case 10 :
            case 11 :
        }
    }
    // 矩阵乘法
    public static void main4(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str[] = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input[] = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            b[i][i] = 1;
        }

        while(m-- != 0) {
            c = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        c[i][j] += b[i][k] * a[k][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = c[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 杨辉三角
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 进制转换
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String hex = Integer.toHexString(n);
        System.out.println(hex.toUpperCase(Locale.ROOT));
    }
    // 数字游戏
    public static void main1(String[] args) throws IOException {
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
