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
         * 1���ֲ��ڲ����Ƕ������ⲿ��ľֲ�λ�ã�ͨ���ڷ���
         * 2������ֱ�ӷ����ⲿ������г�Ա������˽�е�
         * 3��������ӷ������η������ǿ���ʹ��final����
         * 4��������ֻ���ڶ������ķ�����������
         * 5���ֲ��ڲ������ֱ�ӷ����ⲿ��ĳ�Ա
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