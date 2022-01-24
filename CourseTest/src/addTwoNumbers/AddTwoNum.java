package addTwoNumbers;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-12
 * Time: 16:18
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
public class AddTwoNum {
    ListNode head;

    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    public void display(ListNode node) {
        ListNode cur = node;
        if(node == null) {
            System.out.println(" ");
            return;
        }
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public int size(ListNode node) {
        int count = 0;
        ListNode cur = node;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode listLong = l1;
        ListNode listShort = l2;

        if(size(l1) < size(l2)) {
            listLong = l2;
            listShort = l1;
        }
        ListNode newList = new ListNode(-1);
        int scale = 0;
        while(newList != null) {
            if(listLong.next != null) {
                ListNode node = new ListNode(-1);
                newList.next = node;
            }
            int addNum = listShort.val+listLong.val;
            newList.val = (addNum + scale) % 10;
            scale = addNum / 10;
            if(listLong.next == null && listShort.next == null && scale != 0) {
                ListNode newNode = new ListNode(scale);
                newList.next = newNode;
                break;
            }
            if(l1.next == null || l2.next == null) {

            }
            newList = newList.next;
            l1 = l1.next;
            l2 = l2.next;
        }
    }
}
