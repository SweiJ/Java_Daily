package TestDemo.LinkList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-06
 * Time: 19:19
 */
public class LinkListTest {
    public static void main(String[] args) {
        MyLinkList myLinkList1 = new MyLinkList();
        myLinkList1.addLast(21);
        myLinkList1.addLast(10);
        myLinkList1.addLast(12);
        myLinkList1.addLast(26);
        myLinkList1.addLast(56);

//        myLinkList2.head.next.next = myLinkList1.head.next;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) {
            return null;
        }
        ListNode pl = headA;
        ListNode ps = headB;
        int lenA = 0;
        int lenB = 0;

        while(pl != null) {
            lenA++;
            pl = pl.next;
        }
        while(ps != null) {
            lenB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = -len;
        }

        while(len != 0) {
            pl = pl.next;
            len--;
        }
        while(pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast != null || fast.next != null){
            return null;
        }
        while(fast != cur) {
            cur = cur.next;
            fast = fast.next;
        }
        return cur;
    }
}
