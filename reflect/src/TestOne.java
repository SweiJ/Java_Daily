/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 9:26
 */
public class TestOne {
    private int age;

    public TestOne() {
        System.out.println("构造方法！");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestOne{" +
                "age=" + age +
                '}';
    }
}
