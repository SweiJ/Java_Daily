package xxx;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-06
 * Time: 19:20
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
    public void deleteVal(int val) {
        ListNode cur = this.head.next;
        ListNode prev = this.head;

        while(cur != null) {
            if(cur.value == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.value == val) {
            this.head = this.head.next;
        }
    }
    public void reversal() {
        this.head = reversalList();
    }
    public ListNode reversalList() {
        ListNode cur = this.head.next;
        ListNode prev = this.head;
        while(cur != null) {
            cur.next = prev;
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}