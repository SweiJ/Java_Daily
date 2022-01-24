import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-10-26
 * Time: 9:03
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,6,4,1,2};

        numOne(arr);
    }

    public static void numOne(int[] arr) {
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num ^= arr[i];
        }
        System.out.println(num);
    }
    public static String toString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if(i != arr.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }
    public static int[] copyOf(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    public static void binSearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while(left <= right) {
            if(arr[mid] > num) {
                right = mid - 1;
            } else if(arr[mid] < num) {
                left = mid + 1;
            } else {
                System.out.println("下标为" + mid);
                break;
            }
            mid = (left + right) / 2;
        }
        if(left > right) {
            System.out.println("没有找到！");
        }
    }

    public static boolean isSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i- 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
    }
    public static void setArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2* arr[i];
        }
    }

    public static int sum(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
        }
        return ret;
    }

    public static double avg(int[] arr) {
        double ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
        }
        return ret / arr.length;
    }
}
