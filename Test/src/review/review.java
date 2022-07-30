package review;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-18
 * Time: 8:29
 */
public class review {
//    public static void main(String[] args) {
//        Info<Integer> info = new Info<Integer>();
//        info.setVar(30);
//        System.out.println(info.getVar());
//
//        exampleClass<Integer> exampleClass = new exampleClass<Integer>();
//        String integer = exampleClass.exampleMethod("xiaojiang");
//        System.out.println(integer);
//    }

    public static void main(String[] args) {
        Person xiaoZhang = new Person("小张");
        Person xiaoLi = new Person("小李");
        Person.swap(xiaoZhang, xiaoLi);
        System.out.println("xiaoZhang:" + xiaoZhang.getName());
        System.out.println("xiaoLi:" + xiaoLi.getName());
    }
}

class exampleClass<T> {
    public <E> E exampleMethod(E e) {
        System.out.println(e);
        return e;
    }
}

class Info<T extends Number> {
    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return "Info{" +
                "var=" + var +
                '}';
    }
}

class Person {
    private String name;
    // 省略构造函数、Getter&Setter方法


    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void swap(Person person1, Person person2) {
        person1.setName("person1");
        person2.setName("person2");
//        Person temp = person1;
//        person1 = person2;
//        person2 = temp;
        System.out.println("person1:" + person1.getName());
        System.out.println("person2:" + person2.getName());
    }
}

