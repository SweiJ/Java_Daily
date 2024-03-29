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
    public static int[][] arr;
    public static int[] arrx = {0,-1,0,1};
    public static int[] arry = {-1,0,1,0};
    public static int ex, ey, n;
    public static Boolean[][] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        vis = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        String[] s = bf.readLine().split(" ");
        int bx = Integer.parseInt(s[0]);
        int by = Integer.parseInt(s[1]);
        ex = Integer.parseInt(s[2]);
        ey = Integer.parseInt(s[3]);
        if(arr[bx - 1][by - 1] == 1) {
            System.out.println("NO");
            return;
        }
        System.out.println(dfs(bx - 1, by - 1) ? "YES" : "NO");
    }

    public static Boolean isPass(int x, int y) {
        // x >= 0 && x < ex && y >= 0 && y < ey 判读当前坐标是否在范围内
        // vis[i][j] 判断当前坐标是否走过
        // arr[i][j] != 1 判断当前坐标是否是墙
        if((x >= 0 && x < ex && y >= 0 && y < ey) && !vis[x][y] && arr[x][y] != 1) {
            return true;
        }
        return false;
    }
    public static Boolean dfs(int x, int y) {
        if(x == ex - 1 && y == ey - 1) {
            return true;
        }
        vis[x][y] = true;
        // 遍历四个方向
        for (int i = 0; i < 4; i++) {
             int xx = x + arrx[i];
             int yy = y + arry[i];
            if(isPass(xx, yy) && dfs(xx, yy)) {
                return true;
            }
        }
        return false;
    }
    public static void main20(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public Boolean isPlain(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if(isPlain(str) && str.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }
    public static void main19(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        square(n);
    }
    public static void square(int n) {
        for (int i = 0; i < Math.sqrt(n); i++) {
            if(i * i <= n) {
                for (int j = i; j < Math.sqrt(n); j++) {
                    if(i * i + j * j <= n) {
                        for (int k = j; k < Math.sqrt(n); k++) {
                            if(i * i + j * j + k * k <= n) {
                                for (int l = k; l < Math.sqrt(n); l++) {
                                    if(i * i + j * j + k * k + l * l == n) {
                                        System.out.println(i + " " + j + " " + k + " " + l);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main18(String[] args) {
        int[] arr = {-1, 3, 6, 7, -10};
        MaxSubSum(arr);
    }
    public static void MaxSubSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j] * arr[j]);
            }
        }
        System.out.println(dp[n - 1]);
    }
    public static void main17(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();
        String T = bf.readLine();


    }
    public static void main16(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            int temp = Integer.parseInt(s[i]);
            set.add(temp);
        }
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        Arrays.sort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
    public static void main15(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int t=sc.nextInt();
        int w=sc.nextInt();
        char jam[]=sc.next().toCharArray();
        int i=w;
        int j,count=0;
        while (--i>=0){
            char a = (char) ('a' + t);
            j=i;
            while (jam[j] < a - (w-j)){
                jam[j]+=1;
                while (++j<w){
                    jam[j]= (char) (jam[j-1]+1);
                }
                count++;
                System.out.println(jam);
                if(count==5)
                    return;
                j=w-1;
            }
            i=j;
        }
    }
    public static void main14(String[] args) {
        String s = Integer.toBinaryString(1001);
        System.out.println(s);
    }
    public static void main13(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");
        int s = Integer.parseInt(arr[0]);
        int t = Integer.parseInt(arr[1]);
        int w = Integer.parseInt(arr[2]);

        String s1 = bf.readLine();
        int j = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = s; i <= t; i++) {
            char c  = (char) ('a' + i);
            // 如果字符相等则置为1
            if(c == s1.charAt(j)) {
                sb.append(1);
                j++;
            } else {
                sb.append(0);
            }
        }
        int i = Integer.parseInt(String.valueOf(sb));
        while(i-- != 0) {
//            isTrue(i);
        }
    }
//    public static Boolean isTrue(int i) {
//
//    }

    public static void main12(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        for(i = 0;i < n; i++) {
            int x = 0;
            for(j = 0;j < n; j++) {
                if(arr[j][i]==1) {
                    x++;
                }
            }
            if(2 * x > n)
                System.out.print((i + 1) + " ");
        }
    }

    public static void main11(String[] args) {
        for (int i = 0; i < 32; i++) {
            String s = Integer.toBinaryString(i);

            System.out.printf("%05d\n", Integer.parseInt(s));
        }
    }

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
    public static void main10(String args[]){
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
//    private static int[] arr = new int[1005];
//    private static int[] temp = new int[1005];
//    public static void main8(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr, 0, n);
//        temp[0] = arr[0];
//        for (int i = 1; i < n; i++) {
//            temp[i] = temp[i - 1] + arr[i];
//        }
//        while(m-- != 0) {
//            int x = sc.nextInt();
//            if(weight(x, n - 1)) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
//    }
//    public static boolean weight(int x, int i) {
//        if(i < 0)
//            return false;
//        // 两盘重量差大于当前剩余的砝码和
//        if(Math.abs(x) > temp[i])
//            return false;//无法称出
//        if(Math.abs(x) == temp[i] || x==0) {//如果两盘一样重了 或者 剩余的砝码的重量和刚好等于两个盘的差值
//            return true;//可以称出
//        }
//        if(weight(x-arr[i],i-1) || weight(x+arr[i],i-1) || weight(x,i-1))//将该砝码放在砝码盘 、物品盘、不放
//            return true;
//        return false;
//    }
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
