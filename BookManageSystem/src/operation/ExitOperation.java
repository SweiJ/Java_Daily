package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:41
 */
public class ExitOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("ÍË³öÏµÍ³£¡");
        System.exit(0);
    }
}
