package DouLinkList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-08
 * Time: 19:29
 */
class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
/**
 * @author SweiJ
 */
public class DouLinkList {

    /**
     * 指向双向链表的头节点
     */
    public ListNode head;
    /**
     * 指向的是尾巴节点
     */
    public ListNode last;

    public void display() {
        //和单链表的打印方式是一样的
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    //得到单链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.last = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
        }
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.last = node;
            this.head = node;
        } else {
            node.prev = this.last;
            this.last.next = node;
            this.last = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            System.out.println("位置错误！");
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = this.head;
        while(index != 0) {
            index--;
            cur = cur.next;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = cur;
        cur.prev.next = newNode;
        newNode.prev = cur.prev;
        cur.prev = newNode;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                if(cur.next != null) {
                    if(cur == this.head) {
                        this.head = this.head.next;
                        this.head.prev = null;
                        break;
                    }
                    cur.next.prev = cur.prev;
                    cur.prev.next = cur.next;
                } else {
                    cur.prev.next = cur.next;
                    last = last.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        last = last.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public void clear() {
        ListNode cur = this.head;
        while(cur != null) {
            cur = cur.next;
            head.next = null;
            head.prev = null;
            head = cur;
        }
    }
}
