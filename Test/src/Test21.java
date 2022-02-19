import java.util.HashMap;
import java.util.Map;

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
}
