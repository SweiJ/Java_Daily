package house.house;

import house.house.House;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 22:49
 */
public class HouseRent {
    private int useSize;
    House[] house = new House[10];
    public HouseRent() {
        house[0] = new House("king", "4563", "�Ƹ���", "3000");
        house[1] = new House("jack", "123", "�Ƹ���", "4000");
        house[2] = new House("liling", "345", "�Ƹ���", "1000");
        house[3] = new House("����", "6777", "�Ƹ���", "1000");
        house[4] = new House("С��", "1233", "�Ƹ���", "800");
        useSize = 5;
    }
    public House getPos(int pos) {
        return house[pos];
    }
    public void setPos(int pos, House house) {
        this.house[pos] = house;
    }

    public void remove(int pos) {
        this.house[pos] = null;
    }
    public int getUseSize() {
        return useSize;
    }

    public void setUseSize(int useSize) {
        this.useSize = useSize;
    }

    public void addHouse() {

    }

}
