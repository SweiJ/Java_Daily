package addTwoNumbers;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-12
 * Time: 16:18
 */
public class AddTwoNumTest {
    public static void main(String[] args) {
        AddTwoNum addTwoNum  = new AddTwoNum();
        addTwoNum.addFirst(5);
        addTwoNum.addFirst(6);
        addTwoNum.addFirst(4);
        addTwoNum.addFirst(8);

        AddTwoNum addTwoNum1 = new AddTwoNum();
        addTwoNum1.addFirst(3);
        addTwoNum1.addFirst(5);
        addTwoNum1.addFirst(2);

        ListNode ret = addTwoNum.addTwoNumbers(addTwoNum.head, addTwoNum1.head);
        addTwoNum.display(ret);
    }
}
