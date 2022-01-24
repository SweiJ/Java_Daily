package DouLinkList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-08
 * Time: 19:28
 */
public class DouLinkListTest {
    public static void main(String[] args) {
        DouLinkList douLinkList = new DouLinkList();
        douLinkList.addFirst(12);
        douLinkList.addFirst(23);
        douLinkList.addFirst(45);

        douLinkList.addLast(56);
        douLinkList.addLast(45);
        douLinkList.addIndex(2,20);
        douLinkList.display();
    }
}
