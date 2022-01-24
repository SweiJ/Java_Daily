import sun.awt.image.ImageWatched;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-02
 * Time: 19:42
 */
class LinkNode {
    public int value;
    public LinkNode next;

    public LinkNode(int value) {
        this.value = value;
    }
}
public class MySinLink {

    public LinkNode head;

    public void creatLink() {
        LinkNode linkNode1 = new LinkNode(10);
        LinkNode linkNode2 = new LinkNode(20);
        LinkNode linkNode3 = new LinkNode(30);
        LinkNode linkNode4 = new LinkNode(40);
        LinkNode linkNode5 = new LinkNode(50);
        LinkNode linkNode6 = new LinkNode(60);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        this.head = linkNode1;
    }

    public boolean contains(int key){
        LinkNode cur = this.head;
        while(cur != null) {
            if(cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int size() {
        LinkNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        LinkNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public void addFirst(int key) {
        LinkNode node = new LinkNode(key);
        node.next = this.head;
        this.head = node;
    }

    public void addLast(int key) {
        LinkNode node = new LinkNode(key);
        if(this.head == null) {
            this.head = node;
        } else {
            LinkNode cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public LinkNode findNode(int index) {
        LinkNode cur = this.head;
        while(index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            System.out.println("位置不合法！");
        } else if(index == 0) {
            addFirst(data);
        } else if(index == size()) {
            addLast(data);
        } else {
            LinkNode node = new LinkNode(data);
            LinkNode cur = findNode(index);
            node.next = cur.next;
            cur.next = node;
        }
    }

    public LinkNode nodeSearch(int key) {
        LinkNode cur = this.head;
        while(cur.next != null) {
            if(cur.next.value == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public void remove(int key){
        if(this.head == null) {
            System.out.println("链表为空！");
            return;
        }
        if(this.head.value == key) {
            this.head = this.head.next;
            return;
        }
//        LinkNode cur = this.head;
//        while(cur.next != null) {
//            if(cur.next.value == key) {
//                if (cur.next.next != null) {
//                    cur.next = cur.next.next;
//                } else {
//                    cur.next = null;
//                    return;
//                }
//            }
//            cur = cur.next;
//        }
        if(nodeSearch(key) == null) {
            System.out.println("没有找到该数值！");
        } else {
            LinkNode cur = nodeSearch(key);
            cur.next = cur.next.next;
        }
    }

    public LinkNode remoteAllKey(int key) {
        if(this.head == null) {
            return null;
        }

        LinkNode cur = this.head.next;
        LinkNode prev = this.head;

        while(cur != null) {
            if(cur.value == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.value == key) {
            this.head = this.head.next;
        }
        return this.head;
    }

    public void clear(){
        while(this.head != null) {
            LinkNode node = this.head;
            node = this.head.next;
            this.head = null;
            this.head = node;
        }
    }
}
