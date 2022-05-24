package encryption;

import java.util.LinkedList;
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
        boolean flag = false;
        while (true) {
            System.out.println("*************FenceCiper(Java)**********");
            System.out.println("1.明文加密      2.密文解密       3.退出    ");
            System.out.println("*****************************************");
            System.out.print("请输入:>>");
            int operateType = in.nextInt();
            System.out.println();
            in.nextLine();
            switch (operateType) {
                case 1:
                    System.out.print("请输入明文>>");
                    String plaintext = in.nextLine();
                    Encryption(plaintext);
                    break;
                case 2:
                    System.out.print("请输入密文>>");
                    String ciphertext = in.nextLine();
                    Decrypt(ciphertext);
                    break;
                case 3:
                    System.out.println("退出成功!");
                    flag = true;
                    break;
            }
            if (flag) {
                break;
            }
        }
    }

    private static void Decrypt (String mstr){
        for (int i = 2; i < mstr.length(); i++) {
            StringBuilder result = new StringBuilder();
            LinkedList<String> list = new LinkedList<>();
            if (mstr.length() % i == 0) {
                int n = mstr.length() / i;
                for (int j = 0; j < n; j++) {
                    for (int k = j; k < mstr.length(); k+=n) {
                        result.append(mstr.charAt(k));
                    }
                }
                System.out.println(i + "栏解密的结果是" + result);
            }
        }
    }

    private static void Encryption (String mstr) {
        for (int i = 2; i < mstr.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            if (mstr.length() % i == 0) {
                for (int j = 0; j < i; j++) {
                    StringBuilder builder = new StringBuilder();
                    for (int k = j; k < mstr.length(); k += i) {
                        builder.append(mstr.charAt(k));
                    }
                    list.add(builder.toString());
                }
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < list.size(); j++) {
                    result.append(list.get(j));
                }
                System.out.println(i + "栏加密的结果是" + result);
            }
        }
    }
}
