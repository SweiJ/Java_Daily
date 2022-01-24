/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 16:08
 */
public class FindJudgeTest {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        int index = 0;
        for (int i = 0; i < trust.length; i++) {
            int tmp = trust[i][1];
            arr[tmp]++;
            if(arr[tmp] == n - 1) {
                index = tmp;
            }
        }
        if(index != 0) {
            byte flag = 1;
            for (int i = 0; i < trust.length; i++) {
                if(trust[i][0] == index) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                return index;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
