package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:40
 */
public class AddOperation implements IOperation {
    public AddOperation() {

    }

    @Override
    public void work(BookList bookList) {

        System.out.println("新增图书！");
        System.out.println("请输入书名：");
        String name = scanner.nextLine();
        System.out.println("请输入作者：");
        String auther = scanner.nextLine();
        System.out.println("请输入价格：");
        int price = scanner.nextInt();
        System.out.println("请输入类型：");
        scanner.nextLine();
        String type = scanner.nextLine();

        Book book = new Book(name, auther, price, type);
        bookList.addPos(bookList.getUsedSize(), book);
        bookList.setUsedSize(bookList.getUsedSize() + 1);
        System.out.println("新增图书成功！");
    }
}
