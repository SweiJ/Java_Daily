package com.xxxx;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-03
 * Time: 15:27
 */
class SinLinkNode {
    public int value;
    public SinLinkNode next;

    public SinLinkNode(int value) {
        this.value = value;
    }
}
public class MySinLinkList {

    SinLinkNode head = null;

    public void CreatSinLink() {
        SinLinkNode sinLinkNode1 = new SinLinkNode(10);
        SinLinkNode sinLinkNode2 = new SinLinkNode(20);
        SinLinkNode sinLinkNode3 = new SinLinkNode(30);
        SinLinkNode sinLinkNode4 = new SinLinkNode(40);
        SinLinkNode sinLinkNode5 = new SinLinkNode(50);
        SinLinkNode sinLinkNode6 = new SinLinkNode(60);
        sinLinkNode1.next = sinLinkNode2;
        sinLinkNode2.next = sinLinkNode3;
        sinLinkNode3.next = sinLinkNode4;
        sinLinkNode4.next = sinLinkNode5;
        sinLinkNode5.next = sinLinkNode6;
        this.head = sinLinkNode1;
    }

    public void display() {
        SinLinkNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
    public int size() {
        SinLinkNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //ͷ�巨
    public void addFirst(int data){
        SinLinkNode node = new SinLinkNode(data);
        node.next = this.head;
        this.head = node;
    }

    //β�巨
    public void addLast(int data){
        SinLinkNode node = new SinLinkNode(data);
        SinLinkNode cur = this.head;
        if(this.head == null) {
            this.head = node;
        } else {
            while(cur.next != null) {
                cur = cur.next;
            }
        }
        cur.next = node;
    }
    //����λ�ò���,��һ�����ݽڵ�Ϊ0���±�
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            System.out.println("λ�ô���");
        } else if(index == 0) {
            addFirst(data);
        } else {
            SinLinkNode cur = this.head;
            SinLinkNode node = new SinLinkNode(data);
            while(index != 1) {
                cur = cur.next;
                index--;
            }
            node.next = cur.next;
            cur.next = node;
        }
    }
    //�����Ƿ�����ؼ���key�Ƿ��ڵ�������
    public boolean contains(int key) {
        SinLinkNode cur = this.head;
        while(cur != null) {
            if(cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public SinLinkNode findIndex(int key) {
        SinLinkNode cur = this.head;
        while(cur.next != null) {
            if(cur.next.value == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //ɾ����һ�γ��ֹؼ���Ϊkey�Ľڵ�
    public void remove(int key) {
        if(this.head == null) {
            System.out.println("������");
        }
        if(this.head.value == key) {
            this.head = this.head.next;
            return;
        }
        if(findIndex(key) != null) {
            SinLinkNode cur = findIndex(key);
            cur.next = cur.next.next;
        } else {
            System.out.println("û���ҵ�����ֵ��");
        }
    }
    //ɾ������ֵΪkey�Ľڵ�
    public void removeAllKey(int key){
        if(this.head == null) {
            System.out.println("������");
        }
        SinLinkNode cur = this.head.next;
        SinLinkNode prev = this.head;
        while(cur != null) {
            if(cur.value == key) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.value == key) {
            this.head = this.head.next;
        }
    }

    public void clear() {
        this.head = null;
    }
}
