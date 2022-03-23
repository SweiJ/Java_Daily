package leecode;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-21
 * Time: 9:37
 */
class StoreValue {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int begin = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if(s > '0' && s < '9') {
                begin = i;
                while (i < str.length() && str.charAt(i) > '0' && str.charAt(i) < '9') {
                    i++;
                }
                end = i;
                if(end == str.length() - 1) {
                    end++;
                }
                String t = str.substring(begin, end);

                if (sb.length() < t.length()) {
                    sb.delete(0, sb.length());
                    sb.append(t);
                }
            }
        }
        System.out.println(sb);
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                 }
            }
        }
        return array[array.length / 2];
    }
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 1;
        for (int i = 1; i < n - 1; i++) {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1] ||
                    arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                count++;
                if(n - 3 != i){
                    i++;
                }
            }
        }
        System.out.println(count);
    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int end = s.length();
        StringBuilder sb = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                sb.append(s, i + 1, end);
                sb.append(" ");
                end = i;
            }
            if(i == 0) {
                sb.append(s, 0, end);
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
    public static void main2(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 3*n;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        Arrays.sort(arr);
        for (int j=n;j<3*n;j+=2){
            sum+=arr[j];
        }
        System.out.println(sum);
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        StringBuilder sb = new StringBuilder("");
        boolean flag = true;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    flag = false;
                }
            }
            if(flag) {
               sb.append(s1.charAt(i));
            }
            flag = true;
        }
        System.out.println(sb);
    }
}
