package text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-09-18 21:36
 */

class Node {
    private Object key;

    private Object value;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;

    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
class MyHashMap {
    private Node[] nodes = new Node[16];

    public void put(Object k, Object v) {
        int hashCode = k.hashCode();
        Node node = new Node(k, v);
        Node currentNode = nodes[hashCode];

        if(currentNode != null) {
            if(currentNode.equals(node)) {
                currentNode = node;
            }
        }
    }

    public Object get(Object key) {
        int hashCode = key.hashCode();
        Node node = nodes[hashCode];


        return node;
    }

}
public class Text {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("foo", "bar");
        hashMap.get("foo");

    }
}
