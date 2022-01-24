package TestDemo.LinkList.MergeList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-05
 * Time: 20:24
 */
class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
class MyLinkList {
    ListNode head = null;

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if(head == null) {
            head = newNode;
            return;
        }
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }
    public void dispaly() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}
public class MergeListTest {

    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();

        myLinkList.addLast(10);
        myLinkList.addLast(20);
        myLinkList.addLast(30);
        myLinkList.addLast(40);

        MyLinkList myLinkList1 = new MyLinkList();
        myLinkList1.addLast(15);
        myLinkList1.addLast(16);
        myLinkList1.addLast(21);
        myLinkList1.addLast(25);

        ListNode ret = mergeTwoLists(myLinkList.head, myLinkList1.head);

        myLinkList.dispaly();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        newHead.next = l1;
        ListNode tmp = newHead;
        while(l1 != null && l2 != null) {
            if(l1.value < l2.value) {
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if(l1 != null) {
            tmp.next = l1;
        }
        if(l2 != null) {
            tmp.next = l2;
        }
        return newHead.next;
    }
}
