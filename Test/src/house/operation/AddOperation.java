package house.operation;

import house.house.House;
import house.house.HouseRent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 23:09
 */
public class AddOperation implements IOperation {
    @Override
    public void work(HouseRent houseRent) {
        System.out.println("请输入姓名：>");
        String name = scanner.nextLine();
        System.out.println("请输入电话：>");
        String tel = scanner.nextLine();
        System.out.println("请输入地址：>");
        String address = scanner.nextLine();
        System.out.println("请输入月租：>");
        String monRent = scanner.nextLine();
        House house1 = new House(name, tel, address, monRent);
        int size = houseRent.getUseSize();
        houseRent.setPos(size, house1);
        houseRent.setUseSize(size + 1);
        System.out.println("新增成功！");
    }
}
