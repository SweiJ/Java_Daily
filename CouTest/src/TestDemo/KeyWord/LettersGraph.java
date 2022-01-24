package TestDemo.xxx;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-05
 * Time: 15:14
 */
public class LettersGraph {
    public static void main(String[] args) {
        String[] alphabet = {"A","B","C","D","E","F","G"};
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j == 0) {
                    System.out.println("A" + i);
                } else {
                    System.out.print("A" + i);
                }
            }
        }
    }
}
