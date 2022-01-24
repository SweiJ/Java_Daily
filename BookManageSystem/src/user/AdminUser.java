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
        System.out.println("��ӭ" + this.name + "��ã�");
        System.out.println("========����Ա�˵�========");
        System.out.println("1������ͼ�飡");
        System.out.println("2������ͼ�飡");
        System.out.println("3��ɾ��ͼ�飡");
        System.out.println("4����ʾͼ�飡");
        System.out.println("0���˳�ϵͳ��");
        System.out.println("=========================");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
