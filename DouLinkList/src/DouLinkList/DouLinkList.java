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
     * ָ��˫�������ͷ�ڵ�
     */
    public ListNode head;
    /**
     * ָ�����β�ͽڵ�
     */
    public ListNode last;

    public void display() {
        //�͵�����Ĵ�ӡ��ʽ��һ����
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    //�õ�������ĳ���
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //�����Ƿ�����ؼ���key�Ƿ��ڵ�������
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

    //ͷ�巨
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
    //β�巨
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
    //����λ�ò���,��һ�����ݽڵ�Ϊ0���±�
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            System.out.println("λ�ô���");
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

    //ɾ����һ�γ��ֹؼ���Ϊkey�Ľڵ�
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
    //ɾ������ֵΪkey�Ľڵ�
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
