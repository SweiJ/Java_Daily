import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * ���������޶�����
 *      public�����е�
 *      private��˽�е�
 *      protectde: �ܱ�����
 *      ʲô����д��Ĭ��Ȩ��->������Ȩ��
 * User: SweiJ
 * Date: 2021-10-23
 * Time: 15:30
 */

class Person {
    // �ֶ�->��Ա���� �����ڷ����� �������
    // ʵ����Ա������ ��������
    // ʵ����Աû�г�ʼ�� Ĭ��ֵΪ��Ӧ��0 ��������Ĭ��Ϊnull
    public String name;
    public int age;

    // ��̬��Ա����
    // �����ڶ��� ������ ���ڷ�������
    // û�г�ʼ����ʵ����Ա������һ����
    public static int size;

    // ����->��Ϊ
    // ʵ����Ա���� ���Ե���ʵ����Ա�;�̬��Ա�ķ����ͱ���
    public void eat() {
        // �ֲ�������ʹ�õ�ʱ�����Ҫ��ʼ��
        int a = 10;
        System.out.println("eat!");
    }

    public void study() {
        System.out.println("study!");
    }

    // ��̬��Ա���� ֻ�ܵ��þ�̬��Ա�����ͱ���
    public static void sleep() {
        System.out.println("sleep!");
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * ��װ����private���������� ���� ���� ֻ���ڵ�ǰ����ʹ��
 * ΪʲôҪ��װ
 *  û������Ҫ������һ����Ϊ˽��
 * this�� ��ǰ����� ����
 * this()�������Լ��Ĺ��췽��
 *    ע�⣺
 *       1��ֻ���ڹ��췽������д
 *       2��ֻ�ܵ���һ��
 *       3��ֻ��д�ڵ�һ��
 *       4.����ͨ��this�ݹ���ù��췽��
 * this.��Ա���������õ�ǰ���������
 * this.func()�����õ�ǰ����ķ���
 * User: SweiJ
 * Date: 2021-10-23
 * Time: 17:30
 */
class Student {
    private String name;
    private int age;

    // ������ӷ��� alt+insert
    // �ṩһ�������Ľӿ�
    public String getName() {
        return name;
    }
    // ��������ʹ��˽�б���ʱ���� this �����ñ������������
    public void setName(String name) {
        this.name = name;
    }

    // ���� ʵ����Object���toString()����
    // Object ��������ĸ��� alt+insert   ->toString
    @Override // ע�⣺���ע��ָ���� �������������д��
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
 *  һ������Ĳ�����Ϊ������
 *  1��Ϊ��������ڴ�
 *  2�����ú��ʵĹ��췽��  ���췽�����Բ�ֹһ��
 *  ���췽�������ķ���������������ͬ�ģ���û�з���ֵ
 *  ���ã���������
 *  ��û���ṩ���췽����ʱ����ô���������Զ��ṩһ���������в����Ĺ��췽��
 *  ���ṩ�˹��췽�����������Ͳ������ṩ���췽��
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
 * ����飺��̬�����  ʵ�������  ���ش����(ֻ���˽�)
 *  ��newһ������Ĺ����У�����ִ�е��Ǿ�̬����� Ȼ����ʵ������� ����ǹ��췽��
 *  ��̬�����ݣ�ֻ�ᱻִ��һ�Σ��������类ִ�е�
 *  ������Ǿ�̬�ģ���ô�Ͷ����ǰ��˳���й�
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
        color = "��ɫ";
        System.out.println("��̬�����...");
    }
    {
        this.name = "laohu";
        System.out.println("ʵ�������...");
    }
    public Animal() {
        System.out.println("Animal");
    }
}
public class TestDemo {
    // ʵ����һ������ ͨ���ؼ��� new
    public static void main(String[] args) {
        // �������еĳ�Ա���� ��Ҫ��new һ������
        Person person = new Person();
        // �ö���.��Ա����
        int a = person.age;
        System.out.println(a);
        System.out.println(person.age);

        // ���ʾ�̬�����ݳ�Ա ����.��̬��Ա����
        System.out.println(Person.size);

        // �������еķ���
        person.eat();
        Person.sleep();

        Student student = new Student();

        student.setName("С��");
        System.out.println(student.getName());
        System.out.println(student);

        Book book1 = new Book();
        Book book2 = new Book("Java�������", 54);
        System.out.println(book1);
        System.out.println(book2);

        Animal animal = new Animal();
        // �������� ֻ��ʹ��һ�� �´�ʹ����Ҫ���� new
        new Animal().count = 1;
    }
}
