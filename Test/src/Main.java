

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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
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
}

