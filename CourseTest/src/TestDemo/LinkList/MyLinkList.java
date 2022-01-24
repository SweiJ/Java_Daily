package TestDemo.LinkList;

import java.util.List;

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
    public void reversalTest() {
        this.head = reversalList();
    }
    public ListNode reversalList() {
        if(this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        ListNode prev = null;

        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    public ListNode middleNode() {
        if(head == null) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            if(fast == null) {
                return slow;
            }
            slow = slow.next;
        }
        return slow;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if(k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int count = k - 1;
        while(count != 0) {
            fast = fast.next;
            if(fast == null) {
                return null;
            }
            count--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public void pattitionTest(int x) {
        this.head = partition(x);
    }
    public ListNode partition (int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.value < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }
    public void deleteDuplicationTest() {
        this.head = deleteDuplication();
    }
    public ListNode deleteDuplication() {
        if(this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode prev = newHead;
        while(cur != null) {
            if(cur.next != null && cur.value == cur.next.value) {
                while(cur.next != null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = null;
        return newHead.next;
    }
    public boolean chkPalindrome() {
        if(this.head == null) {
            return true;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;

        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while(this.head != slow) {
            if(this.head.value != slow.value) {
                return false;
            }
            if(this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }
    public void getFunc(ListNode node) {
        this.head = node;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
    public ListNode func(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = head.next;
        return head;
    }

}