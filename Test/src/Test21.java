import java.sql.PreparedStatement;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-02-19
 * Time: 14:52
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Test21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for(int i = 1; i <= n; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int res = bag(n, m, w, v);
        System.out.println(res);
    }
    static int bag(int n, int m, int[] w, int[] v) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)				// 前i类
            for (int j = 1; j <= m; j++)			// 容积
                for (int k = 0; k * w[i] <= j; k++)	// 第i类物品被容积允许的数量
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * w[i]] + k * v[i]);
        return dp[n][m];
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] skill = new int[n];
        for (int i = 0; i < n; i++) {
            skill[i] = sc.nextInt();
        }
        int[][] arr = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] dp = skill(n, m, arr, skill);
        int max = dp[0];
        for (int i = 1; i < n - 1; i++) {
            if(max < dp[i]) {
                 max = dp[i];
            }
        }
        System.out.println(max);
    }
    public static int[] skill(int n, int m, int[][] arr, int[] skill) {
        int[] dp = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dp[i] = dp[arr[i][0]] + dp[arr[i][1]];
        }
        return dp;
    }
    public static void main2(String[] args) {
        int[] number = {11,3};
        String str = PrintMinNumber(number);
        System.out.println(str);
    }
    static String PrintMinNumber(int[] numbers) {
        if(numbers.length == 0) {
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Cmp c = new Cmp();
        list.sort(c);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    static class Cmp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String p = Integer.toString(o1);
            String q = Integer.toString(o2);
            String a = p;
            a += q;
            String b = q;
            b += p;
            int i = Integer.parseInt(a) > Integer.parseInt(b) ? 1 : -1;
            return i;
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num-- > 0) {
            StringBuilder sb = new StringBuilder(sc.next());
            System.out.println(isPlalindrome(sb));
        }
    }
    public static int isPlalindrome(StringBuilder sb) {
        // 初始下标
        int left = 0;
        // 末尾下标
        int right = sb.length() - 1;
        while(left < right) {
            // 判断左右两边下标值是否相等
            if(sb.charAt(left) != sb.charAt(right)) {
                // 如果删除左边的下标值, 判断左边的下一个下标值与右边值是否相等
                // 如果相等证明要删除的是左边下标值，否则是右边下标值
                if(sb.charAt(left + 1) == sb.charAt(right)) {
                    return left;
                } else {
                    return right;
                }
            }
            left++;
            right--;
        }
        // 循环到这时，证明该字符串是回文
        return -1;
    }


    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        // 定义dp用来保存相加后的值
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            // 当前面相加的值小于当前值的时候 重新从当前值开始相加
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }
        int max = dp[0];
        // 找出最大的一个
        for (int i = 1; i < dp.length; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str.length() == 0) {
            return result;
        }
        FullPermuDFS(str, result, " ");
        return result;
    }
    public static void FullPermuDFS(String str, ArrayList<String> result, String cur) {
        if(str.length() == 0) {
            if(!result.contains(cur)) {
                result.add(cur);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            FullPermuDFS(str.substring(0, i)+str.substring(i+1, str.length()), result, cur+str.charAt(i));
        }
    }

    void FindPathDFS(TreeNode root, int expectNumber, List<Stack<Integer>> result, Stack<Integer> stack) {
        if(root == null) {
            return;
        }
        stack.push(root.val);
        expectNumber -= root.val;
        if(expectNumber == 0 && root.left == null && root.right == null) {
            result.add(stack);
        }
        FindPathDFS(root.left, expectNumber, result, stack);
        FindPathDFS(root.right, expectNumber, result, stack);
        stack.pop();
    }
    List<Stack<Integer>> FindPath(TreeNode root, int expectNumber) {
        List<Stack<Integer>> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        if(root == null) {
            return result;
        }
        FindPathDFS(root, expectNumber, result, stack);
        return result;
    }
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
             map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        for (; i < pushA.length; i++) {
            st.push(pushA[i]);
            while(!st.isEmpty() && pushA[i] == popA[j]){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }

}
class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap();
        while(cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet();
        if(jewels.length() == 0 || stones.length() == 0) {
            return 0;
        }
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

//    public static void func(String strExce,String strActual) {
//        Set<Character> set = new HashSet();
//        for(int i = 0; i < strExce.length(); i++) {
//            if()
//            set.add(strExce.charAt(i));
//        }
//        for (int i = 0; i < strActual.length(); i++) {
//            set.add(strActual.charAt(i));
//        }
//    }
}

class Node1 {
    public int val;
    public Node left;
    public Node1 right;
    public Node1(int val) {
        this.val = val;
    }
}

//public class BinarySearchTree {
//    public Node1 root = null;
//    public Node1 search(int key) {
//        Node1 cur = root;
//        while(cur != null) {
//            if(cur.val == key) {
//                return cur;
//            }
//            if(cur.val < key) {
//                cur = cur.right;
//            }
//        }
//    }
//
//}




