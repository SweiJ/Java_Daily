package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 21:23
 */
public class Book {
    private String name;
    private String auther;
    private int price;
    private String type;
    private boolean isBorrowed;

    public Book(String name, String auther, int price, String type) {
        this.name = name;
        this.auther = auther;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", auther='" + auther + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ((isBorrowed == true) ? ", 已经被借出" : ", 未被借出") +
                '}';
    }
}
