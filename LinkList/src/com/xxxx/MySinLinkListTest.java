package com.xxxx;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-03
 * Time: 15:27
 */
public class MySinLinkListTest {
    public static void main(String[] args) {
        MySinLinkList mySinLinkList = new MySinLinkList();
        mySinLinkList.CreatSinLink();
        mySinLinkList.addFirst(10);
        mySinLinkList.addLast(70);
        mySinLinkList.addIndex(8, 20);
        mySinLinkList.remove(16);
        mySinLinkList.removeAllKey(20);
        mySinLinkList.display();
        System.out.println();
        System.out.print(mySinLinkList.size());
    }
}
