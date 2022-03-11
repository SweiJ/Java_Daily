/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-11
 * Time: 16:47
 */
public class MergerSort {
    public static void main(String[] args) {

    }
    public void process(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, L + 1, R);
        mergerSort(arr, L, mid, R);
    }
    public void mergerSort(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R- L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 两边的元素从小到大添加到temp数组中
        while(p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 将temp数组中的元素存入arr数组中
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
    }
}
