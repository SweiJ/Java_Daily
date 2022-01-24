package HeadDouLinkList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-12
 * Time: 12:10
 */
class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class HeadDouLinkList {
    /**
     * ָ��˫�������ͷ�ڵ�
     */
    public ListNode head = new ListNode(-1);
    /**
     * ָ�����β�ͽڵ�
     */
    public ListNode last;

    public void display() {
        //�͵�����Ĵ�ӡ��ʽ��һ����
        if(this.head == null) {
            System.out.println("�����ݣ�");
            return;
        }
        ListNode cur = this.head.next;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    //�õ�������ĳ���
    public int size() {
        ListNode cur = this.head.next;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //�����Ƿ�����ؼ���key�Ƿ��ڵ�������
    public boolean contains(int key){
        ListNode cur = this.head.next;
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
        if(this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            this.last = node;
        } else {
            node.next = this.head.next;
            this.head.next = node;
            node.prev = this.head;
            node.next.prev = node;
        }
    }
    //β�巨
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            this.last = node;
        } else {
            ListNode cur = this.head.next;
            while(cur.next != null) {
                cur = cur.next;
            }
            node.prev = cur;
            cur.next = node;
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
        ListNode cur = this.head.next;
        while(index != 0) {
            index--;
            cur = cur.next;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = cur.prev.next;
        cur.prev.next = newNode;
        newNode.prev = cur.prev;
        cur.prev = newNode;
    }

    //ɾ����һ�γ��ֹؼ���Ϊkey�Ľڵ�
    public void remove(int key){
        if(this.head.next == null) {
            return;
        }
        ListNode cur = this.head.next;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head.next) {
                    this.head.next = this.head.next.next;
                    this.head.next.prev = this.head;
                    break;
                } else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        last = last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    //ɾ������ֵΪkey�Ľڵ�
    public void removeAllKey(int key) {
        if(this.head.next == null) {
            return;
        }
        ListNode cur = this.head.next;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head.next) {
                    this.head.next = this.head.next.next;
                    this.head.next.prev = this.head;
                    break;
                } else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
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
