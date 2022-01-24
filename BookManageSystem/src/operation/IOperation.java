package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:42
 */
public interface IOperation {

    Scanner scanner = new Scanner(System.in);

    public void work(BookList bookList);
}
