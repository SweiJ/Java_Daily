package user;

import operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:40
 */
public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.IOperations = new IOperation[] {
            new ExitOperation(),
            new FindOperation(),
            new AddOperation(),
            new DelOperation(),
            new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("欢迎" + this.name + "你好！");
        System.out.println("========管理员菜单========");
        System.out.println("1、查找图书！");
        System.out.println("2、增加图书！");
        System.out.println("3、删除图书！");
        System.out.println("4、显示图书！");
        System.out.println("0、退出系统！");
        System.out.println("=========================");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
