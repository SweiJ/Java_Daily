package HeadDouLinkList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-12
 * Time: 12:10
 */
public class HeadDouLinkListTest {
    public static void main(String[] args) {
        HeadDouLinkList headDouLinkList = new HeadDouLinkList();
        headDouLinkList.addFirst(10);
        headDouLinkList.addFirst(30);
        headDouLinkList.addFirst(30);
        headDouLinkList.addFirst(40);
        headDouLinkList.addLast(50);
        headDouLinkList.addLast(60);
        headDouLinkList.addLast(30);
        headDouLinkList.addIndex(0,25);
        headDouLinkList.removeAllKey(30);
        headDouLinkList.display();
        System.out.println();
        System.out.println("=============");
        headDouLinkList.clear();
        headDouLinkList.display();
    }

}
