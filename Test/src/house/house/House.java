package house.house;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-01
 * Time: 10:16
 */
public class House {
    private String name;
    private String tel;
    private String address;
    private String monRent;
    private boolean status;

    public House(String name, String tel, String address, String monRent) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.monRent = monRent;
    }

    public House(String name, String tel, String address, String monRent, boolean status) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.monRent = monRent;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMonRent() {
        return monRent;
    }

    public void setMonRent(String monRent) {
        this.monRent = monRent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", monRent=" + monRent +
                ", status=" + (status ? "ÒÑ³ö×â" : "Î´³ö×â") +
                '}';
    }
}
