import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 17:40
 */
public class ShiftGridTest {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row = (i+(j+k)/n)%m;
                int col = (j+k)%n;
                arr[row][col]=grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list1.add(arr[i][j]);
            }
            list.add(list1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int num = 4;
        shiftGrid(arr, num);
    }
}
