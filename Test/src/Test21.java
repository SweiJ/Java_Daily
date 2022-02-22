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
    static byte flag = 0;
    public static void main(String[] args) {
        Permutation("abc");
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




