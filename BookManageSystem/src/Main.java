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
        System.out.println("���������������>");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("�����������ݣ�1������Ա�� 0����ͨ�û�");
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
