/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-11
 * Time: 15:41
 */
public class TwoNum {
    public static void main(String[] args) {

    }
    public void printOddTimesNum(int[] arr) {
        int xor = 0;
        // 将数组全部异或 最后只剩下 a ^ b ≠ 0
        // 可以知道a和b不一样 其中必有一位为1
        for (int i : arr) {
            xor ^= i;
        }
        // a^b 提取最右边的相异的1位
        int rightOne = xor & (~xor + 1);

        int onlyOne = 0;
        for (int i : arr) {
            // rightOne只有一位为1 提取所有这位为1 的数 这些数有奇数个
            if((i & rightOne) == rightOne) {
                // 异或之后的结果就是a 或者 b 的值
                onlyOne ^= i;
            }
        }
        // 因为xor是a^b 所以 xor ^ onlyOne 就是a^b^a 或 a^b^b
        System.out.println(onlyOne + " " + (xor ^ onlyOne));
    }
}
