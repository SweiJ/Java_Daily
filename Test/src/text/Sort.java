package text;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-09-18 22:45
 */
public class Sort {

    public static void main(String[] args) {
        Random random = new Random();
        boolean flag = false;
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt();
        }

//        sort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] < arr[i]) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }

//    public static int quickSort(int[] arr, int low, int high) {
//        int baseNum = arr[high];
//        int l = low;
//        for (int i = low; i < high; i++) {
//            if(arr[i] <= baseNum) {
//                int temp = arr[i];
//                arr[i] = arr[l];
//                arr[l] = temp;
//                l++;
//            }
//        }
//        int temp = arr[l];
//        arr[l] = arr[high];
//        arr[high] = temp;
//        return l;
//    }
//
//
//
//    public static void sort(int[] arr, int low, int high) {
//
//        if(low < high) {
//            int i = quickSort(arr, low, high);
//            sort(arr, low, i - 1);
//            sort(arr, i + 1, high);
//        }
//    }

    public static int partition(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        // 将中心元素和指针指向的元素交换位置
        int temp = array[pointer ];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 获取划分子数组的位置
            int position = partition(array, low, high);
            // 左子数组递归调用
            quickSort(array, low, position -1);
            // 右子数组递归调用
            quickSort(array, position + 1, high);
        }
    }
}


