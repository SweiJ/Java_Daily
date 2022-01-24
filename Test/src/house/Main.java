package house;

import house.house.HouseRent;
import house.operation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 22:49
 */
public class Main {
    public static void main(String[] args) {
        HouseRent houseRent = new HouseRent();
        while(true) {
            MenuOperation menuOperation = new MenuOperation();
            menuOperation.work(houseRent);
        }
    }
}
