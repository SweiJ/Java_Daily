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
    int findPosInInOrder(String str,String in,int position){
        char c = str.charAt(position);
        int length = in.length();
        for(int i=0;i<length;i++){
            if(c==in.charAt(i))
                return i;
        }
        return -1;

    }
    /**
     * 已知后序、中序，求先序
     * @param postOrder
     * @param inOrder
     * @param length
     */
    void preOrder(String postOrder,String inOrder,int length){
        if(1==length){
            System.out.println(inOrder);
            return;
        }
        if(0==length){
            return;
        }
        int index = findPosInInOrder(postOrder, inOrder,postOrder.length()-1);
        String inOrder_left = inOrder.substring(0,index);
        String inOrder_right = inOrder.substring(index+1);

        String postOrder_left = postOrder.substring(0,index);
        String postOrder_right = postOrder.substring(index+1,postOrder.length()-1);

        System.out.println(postOrder.charAt(postOrder.length()-1));
        preOrder(postOrder_left,inOrder_left,inOrder_left.length());
        preOrder(postOrder_right,inOrder_right,inOrder_right.length());
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        String in = sc.nextLine();
        String post = sc.nextLine();

        m.preOrder(post, in, in.length());
    }

    public static void main9(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        while(m-- != 0) {
            int pi = sc.nextInt();
            int qi = sc.nextInt();
            if(pi == 0)
            {
                for(int i=0;i<qi-1;i++)
                    for(int j=0;j<qi-i-1;j++)
                    {
                        if(arr[j]<arr[j+1])
                        {
                            Integer s=arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=s;
                        }
                    }
            }
            if(pi == 1)
            {
                for(int i = 0;i < arr.length - qi;i++)
                    for(int j = qi - 1;j <= arr.length - qi - i;j++)
                    {
                        if(arr[j]>arr[j+1])
                        {
                            Integer s=arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=s;
                        }
                    }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static int[] arr = new int[1005];
    private static int[] temp = new int[1005];
    public static void main8(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, 0, n);
        temp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            temp[i] = temp[i - 1] + arr[i];
        }
        while(m-- != 0) {
            int x = sc.nextInt();
            if(weight(x, n - 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean weight(int x, int i) {
        if(i < 0)
            return false;
        // 两盘重量差大于当前剩余的砝码和
        if(Math.abs(x) > temp[i])
            return false;//无法称出
        if(Math.abs(x) == temp[i] || x==0) {//如果两盘一样重了 或者 剩余的砝码的重量和刚好等于两个盘的差值
            return true;//可以称出
        }
        if(weight(x-arr[i],i-1) || weight(x+arr[i],i-1) || weight(x,i-1))//将该砝码放在砝码盘 、物品盘、不放
            return true;
        return false;
    }
    public static void main7(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int p1 = Integer.parseInt(strs[0]);
        int p2 = Integer.parseInt(strs[1]);
        int p3 = Integer.parseInt(strs[2]);

        String str = bf.readLine();
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while(i < sb.length()) {
            char c = sb.charAt(i);
            if(c == '-' && i > 0 && i < sb.length() - 1) {
                // '-' 符号前面的字符和 '-'符号后面的字符
                char begin = sb.charAt(i - 1);
                char end = sb.charAt(i + 1);
                // 前后字符之差 为了找出中间的字符
                int index = end - begin;
                // 当后面的字符比前面字符大时
                StringBuilder temp = new StringBuilder("");
                if(begin < end) {
                    if(((begin >= 'a' && begin <= 'z') && (end >= 'a' && end <= 'z')) || ((begin >= '0' && begin <= '9') && (end >= '0' && end <= '9'))) {
                        while (index-- != 1) {
                            // 寻找当前所需要的字符
                            begin += 1;
                            // 单个字符循环次数
                            int p22 = p2;
                            while (p22-- != 0) {
                                temp.append(begin);
                            }
                        }
                        // 将'-'符号替换
                        if(p3 == 2) {
                            temp.reverse();
                        }
                        String n = temp.toString();
                        if(p1 == 1) {
                            sb.replace(i, i + 1, n);
                        }
                        if(p1 == 2) {
                            sb.replace(i, i + 1, n.toUpperCase(Locale.ROOT));
                        }
                        if(p1 == 3) {
                            for (int j = 0; j < temp.length(); j++) {
                                n = n.replace(n.charAt(j), '*');
                            }
                            sb.replace(i, i + 1, n);
                        }
                    }
                }
            }
            i++;
        }
        System.out.println(sb);
    }
    public static void main6(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // trim删除字符串前后的空白字符
        int n = Integer.parseInt(bf.readLine().trim());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 1; i < n; i++) {
            arr[0][i] = arr[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]) + arr[i][j];
            }
        }
        System.out.println(arr[n - 1][n - 1]);
    }
    public static void main5(String[] args) throws IOException {
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
                // 如果最后一位前面也是0， 则删除"ling "5位
                if (!b)
                    read.delete(read.length() - 5, read.length());
            } else {
                read.append(num[j] + wei[numStr.length() - i - 1]);
                b = true;
            }
        }
        System.out.println(read);
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
