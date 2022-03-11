/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-11
 * Time: 15:08
 */
public class BubSort {
    public static void main(String[] args) {
    }
    public void bubSort(int[] arr) {
        // 如果数组为null 或者 数组元素个数小于2 返回
        if(arr == null || arr.length < 2) {
            return;
        }
        // len - 1 ~ 0
        for (int i = arr.length - 1; i > 0; i--) {
            // 依次将当前最大值向后移
            for (int j = 0; j < i - 1; j++) {
                if(arr[j] < arr[j + 1]) {
                    swap(arr, j , j + 1);
                }
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
