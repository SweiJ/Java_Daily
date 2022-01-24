package house.operation;

import house.house.HouseRent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 23:12
 */
public class DisplayOperation implements IOperation {
    @Override
    public void work(HouseRent houseRent) {
        int size = houseRent.getUseSize();
        for (int i = 0; i < size; i++) {
            System.out.println(houseRent.getPos(i));
        }
    }
}
