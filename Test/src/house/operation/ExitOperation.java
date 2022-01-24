package house.operation;

import house.house.HouseRent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 23:12
 */
public class ExitOperation implements IOperation {
    @Override
    public void work(HouseRent houseRent) {
        System.exit(-1);
    }
}
