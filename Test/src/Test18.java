import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-21
 * Time: 17:08
 */
public class Test18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[100];
        int i = 0;
        while(scanner.hasNext()) {
            str[i++] = scanner.nextLine();
        }
        for(int j = 0; j < n; j++) {
            System.out.println(str[j]);
        }

    }
}
