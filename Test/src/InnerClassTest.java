import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-02
 * Time: 19:29
 */
@SuppressWarnings("all")
public class InnerClassTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        OutClass.InnerClass1 innerClass1 = new OutClass.InnerClass1();
        OutClass.InnerClass2 innerClass2 = outClass.new InnerClass2();
    }
}
class OutClass {
    private String outName;
    private int outAge = 10;
    public void outEat() {
        System.out.println("OutClass.outEat");
    }
    public class InnerClass2 {
        private String innerName;
        private int innerAge;
        public void innerEat() {
            System.out.println("InnerClass2.innerEat");
        }
    }
    static class InnerClass1 {
        private String innerName;
        private int innerAge;
        public void innerEat() {
            System.out.println("InnerClass.innerEat");
        }
    }
    public void outFun() {
        /**
         * 1、局部内部类是定义在外部类的局部位置，通常在方法
         * 2、可以直接访问外部类的所有成员，包含私有的
         * 3、不能添加访问修饰符，但是可以使用final修饰
         * 4、作用域：只能在定义它的方法或代码块中
         * 5、局部内部类可以直接访问外部类的成员
         */
        class FunInnerClass {
            private String funInnerName;
            public void f1() {
                outAge = 20;
                System.out.println("outAge" + outAge);
            }
        }
        FunInnerClass funInnerClass = new FunInnerClass();
        funInnerClass.f1();
    }
    @Override
    public String toString() {
        return "OutClass{" +
                "outName='" + outName + '\'' +
                ", outAge=" + outAge +
                '}';
    }
}