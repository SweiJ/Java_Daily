import javafx.scene.control.Cell;

import java.util.Hashtable;

/**
* Created with IntelliJ IDEA.
* Description:
* User: SweiJ
* Date: 2021-12-04
* Time: 19:22
*/
public class Test7 {
    public static void main2(String[] args) {
        Animal animal = new Animal();
        animal.name = "С��";
        animal.eat();
    }
    public static void main1(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.fun(new Bell() {
            @Override
            public void ring() {
                System.out.println("�������ˣ�");
            }
        });
        cellPhone.fun(new Bell() {
            @Override
            public void ring() {
                System.out.println("С����Ͽ��ˣ�");
            }
        });
    }
}
interface Bell {
    void ring();
}
class CellPhone {
    public void fun(Bell bell) {
        bell.ring();
    }
}

interface Ia{
    void fun();
}
class Dog implements Ia {
    @Override
    public void fun() {
        System.out.println("�Թ�ͷ��");
    }
}
@SuppressWarnings("all")
@Deprecated
class Animal {
    @Deprecated
    public String name;
    @Deprecated
    public void eat() {
        System.out.println("��ʵ�");
    }
}
