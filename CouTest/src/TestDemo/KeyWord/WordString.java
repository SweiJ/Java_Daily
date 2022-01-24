package TestDemo.xxx;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-05
 * Time: 14:49
 */

public class WordString {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            bin(i, 5);
            System.out.println();
        }
    }

    public static void bin(int num, int count) {
        if (count == 0) {
            return;
        } else {
            int divisor = num;
            int remainder = divisor % 2;
            divisor = divisor / 2;
            count--;
            bin(divisor, count);
            System.out.print(remainder);
        }
    }
}