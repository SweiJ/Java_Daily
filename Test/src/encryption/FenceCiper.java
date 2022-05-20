package encryption;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-20
 * Time: 15:30
 */
public class FenceCiper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String normalStr = in.nextLine();
        int n = in.nextInt();
        // 去除空格
        String mstr = quitBlank(normalStr);
        String enStr = en(n, mstr);
        System.out.println("密文>>" + enStr);
        String dnStr = dn(n, enStr);
        System.out.println("解密后明文>>" + dnStr);
    }

    private static String en(int n, String mstr) {
        StringBuilder result = new StringBuilder();
        int step = (int)((double) (mstr.length() / n) + 0.5);
        String[] splitstr = new String[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if(temp + step) {
                splitstr[i] = mstr.substring(temp, temp + step);
            } else {
                splitstr[i] = mstr.substring(temp);
            }
            temp += step;
        }
    }

    private static String quitBlank(String normalStr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < normalStr.length(); i++) {
            if(normalStr.charAt(i) != ' ') {
                builder.append(normalStr.charAt(i));
            }
        }
        return builder.toString();
    }



}
