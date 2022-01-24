package xxx;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-02
 * Time: 12:14
 */
public class Wood {
    public String name;
    public int year;

//    static {
//        System.out.println("Wood.static initializer");
//    }
//
//    {
//        System.out.println("Wood.instance initializer");
//    }

    public Wood() {
        System.out.println("Wood.Wood<>");
    }
    public Wood(String name, int year) {
        this();
        this.name = name;
        this.year = year;
        System.out.println("Wood.Wood<String, int>");
    }

    public void use() {
        System.out.println("Wood.use");
    }

    public Plant get() {
        System.out.println("Wood.get");
        return new Plant();
    }
}
