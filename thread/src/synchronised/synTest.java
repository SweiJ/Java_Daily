package synchronised;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 21:08
 */
@SuppressWarnings("all")
public class synTest {
    public static void main(String[] args) {
//        Animal animal = new Animal("¹·×Ó", 10);
        Syn syn = new Syn();
        Syn1 syn1 = new Syn1();
        Thread t1 = new Thread(() -> {
            syn.fun1();
        }, "t1");
        Thread t2 = new Thread(() -> {
            syn1.fun2(syn);
        }, "t2");

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Syn {
    private int age = 10;
    public synchronized void fun1() {
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1..." + this.age);
    }
    public void fun2() {
        System.out.println("2..." + this.age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Syn1 {
    private int age;
    public void fun2(Syn s) {
        System.out.println(s.getAge());
    }
}