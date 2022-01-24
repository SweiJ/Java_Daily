package user;

import book.BookList;
import operation.IOperation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:40
 */
public abstract class User {
    protected String name;
    protected IOperation[] IOperations;

    public User(String name) {
        this.name = name;
    }
    public abstract int menu();
    public void dowork(int choice, BookList bookList) {
        IOperations[choice].work(bookList);
    }
}
