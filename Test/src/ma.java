import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-02-09
 * Time: 17:29
 */
public class ma {
    static Deque<int[]> list = new LinkedList<>();
    static int[][] steps = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1,}, {-2, 1},
            {-2, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(stepsNum(a,b,c,d,steps.length));
    }

    public static int stepsNum(int a, int b, int c, int d, int len) {
        list.offer(new int[]{a, b});
        int count = 0;
        if(list.getFirst()[0] == c && list.getFirst()[1] == d) {
            return count;
        }

        while() {
            for (int i = 0; i < len; i++) {
                int[] temp = new int[2];
                for (int j = 0; j < 2; j++) {
                    temp[j] = list.getFirst()[j] + steps[i][j];
                }
            }
        }
    }
}
