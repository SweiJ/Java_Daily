import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:57
 */
public class Main {

    public static User login() {
        System.out.println("请输入你的姓名：>");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入你的身份：1、管理员， 0、普通用户");
        int id = scanner.nextInt();
        if(id == 1) {
            return new AdminUser(name);
        } else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        User user = login();
        BookList bookList = new BookList();
        while(true) {
            int choice = user.menu();
            user.dowork(choice, bookList);
        }
    }
}
