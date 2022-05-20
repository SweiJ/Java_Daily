package encryption;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-20
 * Time: 14:43
 */
public class CaesarEncryp {
    private static final int key = 8;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        while(true) {
            System.out.println("*************CaesarCipher(Java)**********");
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
            if(flag) {
                break;
            }
        }
    }

    private static void Encryption(String plaintext) {
        for (int k = 1; k <= key; k++) {
            System.out.print("偏移量为" + k + "加密后为>> ");
            for (int i = 0; i < plaintext.length(); i++) {
                char c = plaintext.charAt(i);
                if(c >= 'a' && c <= 'z') {
                    System.out.print((char)((c + k - 'a') % 26 + 'a'));
                } else if(c >= 'A' && c <= 'Z') {
                    System.out.print((char)((c + k - 'A') % 26 + 'A'));
                } else {
                    System.out.println(c);
                }
            }
            System.out.println();
        }
    }

    private static void Decrypt(String ciphertext) {
        for (int j = 1; j <= key; j++) {
            int k = -j;
            StringBuilder plaintext = new StringBuilder("");
            for (int i = 0; i < ciphertext.length(); i++) {
                char c = ciphertext.charAt(i);
                if(c >='a' && c <= 'z') {
                    c += k % 26;
                    if (c < 'a')
                        c += 26;//向左超界
                    if (c > 'z')
                        c -= 26;//向右超界
                } else if(c >= 'A' && c <= 'Z') {
                    c += k % 26;
                    if (c < 'A')
                        c += 26;//向左超界
                    if (c > 'Z')
                        c -= 26;//向右超界
                }
                plaintext.append(c);//将解密后的字符c连成字符串
            }
            System.out.println("偏移量为" + j + "解密后为: " + plaintext);
        }
    }
}
