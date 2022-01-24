package xxx;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-06
 * Time: 19:19
 */
public class LinkListTest {
    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.addLast(10);
        myLinkList.addLast(20);
        myLinkList.addLast(20);
        myLinkList.addLast(30);
        myLinkList.addLast(40);

//        myLinkList.deleteVal(20);
        myLinkList.reversal();
        myLinkList.dispaly();
    }
}
