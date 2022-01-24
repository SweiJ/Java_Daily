package xxx;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-02
 * Time: 12:12
 */
public class Desk extends Wood {

//    static {
//        System.out.println("Desk.static initializer");
//    }
//
//    {
//        System.out.println("Desk.instance initializer");
//    }

    public Desk() {
        System.out.println("Desk.Desk");
    }
    public Desk(String name, int year, String color) {
        super(name, year);
        System.out.println("Desk.Desk<String, int, String>");
    }

    @Override
    public void use() {
        System.out.println("Desk.use");
    }

    public void PlaceItems() {
        super.use();
        System.out.println("Desk.PlaceItems");
    }

    @Override
    public Tree get() {
        System.out.println("Desk.get");
        return new Tree();
    }
}
