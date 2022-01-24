package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:42
 */
public class ReturnOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书！");
        System.out.println("请输入你要归还的图书名称：");
        String name = scanner.nextLine();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);
            if(book.getName().equals(name)) {
                book.setBorrowed(false);
                System.out.println("归还成功！");
                System.out.println(book);
                break;
            }
        }
        System.out.println("你输入的名称不存在！");
    }
}
