

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-13
 * Time: 14:24
 */

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,5,8,10};

        int[] arr = mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);

        int sum;
        int ans = 0;
        while(!queue.isEmpty()) {
            sum = queue.size();
            ans = Math.max(ans, queue.getLast().val - queue.getFirst().val + 1);
            while(sum > 0) {
                TreeNode temp = queue.remove();

                if(temp.left != null) {
                    queue.add(temp.left);
                    temp.left.val = temp.val * 2 + 1;
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                    temp.right.val = temp.val * 2 + 2;
                }
                sum--;
            }
        }
        return ans;
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();
            if (x > y) {
                pq.offer(x - y);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
    /**
     * 其实就是一个直接插入排序
     * @param array 待排序序列
     * @param gap 组数
     */
    public static void shell(int[] array,int gap) {
        int len = (array.length - 1) / gap;
        for (int i = len; i < array.length; i++) {
            for (int j = i - len; j >= 0; j-=len) {
                if(array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        shell(array, 1);//保证最后是1组
    }
    /**
     *
     * @param array1 有序的
     * @param array2 有序的
     * @return
     */
    public static int[] mergeArray(int[] array1,int[] array2) {
        int n = array1.length + array2.length;
        int[] temp = new int[n];
        int s1 = 0, s2 = 0;
        int e1  = array1.length - 1, e2 = array2.length - 1;

        for (int i = 0; i < n; i++) {
            if(s1 <= e1 && s2 <= e2) {
                if (array1[s1] > array2[s2]) {
                    temp[i] = array2[s2++];
                } else {
                    temp[i] = array1[s1++];
                }
            } else {
                if(s1 <= e1) {
                    for (int j = i; j < n; j++) {
                        temp[i] = array1[s1++];
                    }
                }
                if(s2 <= e2) {
                    for (int j = i; j < n; j++) {
                        temp[i] = array2[s2++];
                    }
                }
            }
        }
        return temp;
    }
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
    }
    public static void mergeSortInternal(int[] array, int low, int high) {
        int mid = low + (low - high) >>> 1;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid + 1, high);
        merge(array, low, mid, high);

    }
    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high];
        int s2 = mid + 1;
        int k = 0;
        while(low <= mid && mid + 1 <= high) {
            if(array[low] <= array[mid +1]) {
                temp[k++] = array[low++];
            } else {
                temp[k++] = array[s2++];
            }
        }
    }
}

