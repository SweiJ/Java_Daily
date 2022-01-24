/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-02
 * Time: 19:42
 */
public class MySinLinkTest {

    public static void main(String[] args) {
        MySinLink mySinLink = new MySinLink();
        mySinLink.creatLink();
        mySinLink.addLast(100);
        mySinLink.remove(20);
        System.out.println(mySinLink.size());
        mySinLink.display();
    }
}
