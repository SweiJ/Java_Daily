package house.operation;

import house.house.HouseRent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 23:13
 */
public class MenuOperation implements IOperation {
    IOperation[] iOperations = new IOperation[7];

    public MenuOperation() {
        this.iOperations = new IOperation[] {
                new ExitOperation(),
                new AddOperation(),
                new FindOperation(),
                new DelOperation(),
                new ModHouseOperation(),
                new DisplayOperation()
        };
    }

    @Override
    public void work(HouseRent houseRent) {
        System.out.println("---------------房屋出租系统---------------");
        System.out.println("             1、新 增 房 源               ");
        System.out.println("             2、查 找 房 屋               ");
        System.out.println("             3、删 除 房 屋               ");
        System.out.println("             4、修 改 房 屋 信 息          ");
        System.out.println("             5、房 屋 列 表               ");
        System.out.println("             0、退      出               ");
        System.out.println("----------------------------------------");
        System.out.println("请选择：>");
        int choice = scanner.nextInt();
        scanner.nextLine();
        iOperations[choice].work(houseRent);
    }
}
