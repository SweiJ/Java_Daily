/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-03
 * Time: 19:54
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
        anonymousInnerClass.fun1();
    }
}
class AnonymousInnerClass {
    private String name;
    private int age;
    public void fun() {
        System.out.println("AnonymousInnerClass.fun");
    }
    public void fun1() {
        Io io = new Io() {
            @Override
            public void func() {
                fun();
                System.out.println("AnonymousInnerClass.func1");
            }
        };
        io.func();
        System.out.println(io.getClass());
    }
    public void fun2() {
        Book book = new Book("xiaojiang"){

            @Override
            public void b() {
                System.out.println(this.nn);
                super.b();
                fun();
            }
        };
        book.b();
        System.out.println(book);
    }
}
interface Io {
    void func();
}
class Book {
    public String nn;

    public Book(String nn) {
        this.nn = nn;
    }

    public void b () {
        System.out.println("Book.b");
    }
}
