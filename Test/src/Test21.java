import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public static void func(String strExce,String strActual) {
        Set<Character> set = new HashSet();
        for(int i = 0; i < strExce.length(); i++) {
            if()
            set.add(strExce.charAt(i));
        }
        for (int i = 0; i < strActual.length(); i++) {
            set.add(strActual.charAt(i));
        }
    }
}

class Node1 {
    public int val;
    public Node left;
    public Node right;
    public Node1(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    public Node1 root = null;
    public Node1 search(int key) {
        Node1 cur = root;
        while(cur != null) {
            if(cur.val == key) {
                return cur;
            }
            if(cur.val < key) {
                cur = cur.right;
            }
        }
    }

}
