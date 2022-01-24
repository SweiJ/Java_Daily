package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:41
 */
public class DisplayOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("œ‘ æÕº È£°");
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            System.out.println(bookList.getPos(i));
        }
    }
}
