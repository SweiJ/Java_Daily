package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:41
 */
public class BorrowOperation implements IOperation {

    public BorrowOperation() {

    }

    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书！");
        System.out.println("请输入你要借阅的图书名称：");
        String name = scanner.nextLine();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);
            if(book.getName().equals(name)) {
                book.setBorrowed(true);
                System.out.println("借阅成功！");
                System.out.println(book);
                return;
            }
        }
        System.out.println("你输入的图书名称错误！");
    }
}
