import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 访问修饰限定符：
 *      public：共有的
 *      private：私有的
 *      protectde: 受保护的
 *      什么都不写：默认权限->包访问权限
 * User: SweiJ
 * Date: 2021-10-23
 * Time: 15:30
 */

class Person {
    // 字段->成员变量 定义在方法外 类的里面
    // 实例成员变量： 对象里面
    // 实例成员没有初始化 默认值为对应的0 引用类型默认为null
    public String name;
    public int age;

    // 静态成员变量
    // 不属于对象 属于类 放在方法区中
    // 没有初始化和实例成员变量是一样的
    public static int size;

    // 方法->行为
    // 实例成员方法 可以调用实例成员和静态成员的方法和变量
    public void eat() {
        // 局部变量在使用的时候必须要初始化
        int a = 10;
        System.out.println("eat!");
    }

    public void study() {
        System.out.println("study!");
    }

    // 静态成员方法 只能调用静态成员方法和变量
    public static void sleep() {
        System.out.println("sleep!");
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 封装：用private来修饰属性 或者 方法 只能在当前类中使用
 * 为什么要封装
 *  没有特殊要求，属性一般设为私有
 * this： 当前对象的 引用
 * this()：调用自己的构造方法
 *    注意：
 *       1、只能在构造方法里面写
 *       2、只能调用一次
 *       3、只能写在第一行
 *       4.不能通过this递归调用构造方法
 * this.成员变量：调用当前对象的属性
 * this.func()：调用当前对象的方法
 * User: SweiJ
 * Date: 2021-10-23
 * Time: 17:30
 */
class Student {
    private String name;
    private int age;

    // 快速添加方法 alt+insert
    // 提供一个公开的接口
    public String getName() {
        return name;
    }
    // 当在类中使用私有变量时加上 this 表明该变量属于这个类
    public void setName(String name) {
        this.name = name;
    }

    // 重新 实现了Object类的toString()方法
    // Object 是所有类的父类 alt+insert   ->toString
    @Override // 注解：这个注解指的是 这个方法是重新写的
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  一个对象的产生分为两步：
 *  1、为对象分配内存
 *  2、调用合适的构造方法  构造方法可以不止一个
 *  构造方法：它的方法名和类名是相同的，且没有返回值
 *  作用：构造对象的
 *  当没有提供构造方法的时候，那么编译器会自动提供一个，不带有参数的构造方法
 *  当提供了构造方法，编译器就不会再提供构造方法
 * User: SweiJ
 * Date: 2021-10-23
 * Time: 19:33
 */
class Book {
    private String BookName;
    private int Price;

    // alt+insert  ->Constructor
    public Book() {
        this("hello", 64);
    }
    public Book(String bookName, int price) {
        this.BookName = bookName;
        this.Price = price;
        System.out.println("book<String, int>");
    }
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "book{" +
                "BookName='" + BookName + '\'' +
                ", Price=" + Price +
                '}';
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 代码块：静态代码块  实例代码块  本地代码块(只做了解)
 *  在new一个对象的过程中，首先执行的是静态代码块 然后是实例代码块 最后是构造方法
 *  静态的内容，只会被执行一次，且是最早被执行的
 *  如果都是静态的，那么和定义的前后顺序有关
 * User: SweiJ
 * Date: 2021-10-23
 * Time: 20:20
 */
class Animal {
    private String name;
    private int age;
    private static String color;
    public int count;
    static {
        color = "黑色";
        System.out.println("静态代码块...");
    }
    {
        this.name = "laohu";
        System.out.println("实例代码块...");
    }
    public Animal() {
        System.out.println("Animal");
    }
}
public class TestDemo {
    // 实例化一个对象 通过关键字 new
    public static void main(String[] args) {
        // 访问类中的成员变量 需要先new 一个对象
        Person person = new Person();
        // 用对象.成员变量
        int a = person.age;
        System.out.println(a);
        System.out.println(person.age);

        // 访问静态的数据成员 类名.静态成员变量
        System.out.println(Person.size);

        // 访问类中的方法
        person.eat();
        Person.sleep();

        Student student = new Student();

        student.setName("小姜");
        System.out.println(student.getName());
        System.out.println(student);

        Book book1 = new Book();
        Book book2 = new Book("Java程序设计", 54);
        System.out.println(book1);
        System.out.println(book2);

        Animal animal = new Animal();
        // 匿名对象 只能使用一次 下次使用需要重新 new
        new Animal().count = 1;
    }
}
