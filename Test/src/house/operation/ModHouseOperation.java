package house.operation;

import house.house.House;
import house.house.HouseRent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 23:11
 */
public class ModHouseOperation implements IOperation {
    @Override
    public void work(HouseRent houseRent) {
        System.out.println("请输入电话：>");
        String oldTel = scanner.nextLine();
        int size = houseRent.getUseSize();
        int i = 0, index = 0;
        for (i = 0; i < size; i++) {
            if(houseRent.getPos(i).getTel().equals(oldTel)) {
                index = i;
                break;
            }
        }
        if(i >= size) {
            System.out.println("没有你要修改的房屋信息！");
        } else {
            System.out.println("请输入姓名：>");
            String name = scanner.nextLine();
            System.out.println("请输入电话：>");
            String tel = scanner.nextLine();
            System.out.println("请输入地址：>");
            String address = scanner.nextLine();
            System.out.println("请输入月租：>");
            String monRent = scanner.nextLine();
            System.out.println("请输入状态：>");
            boolean status = scanner.nextBoolean();
            House house1 = new House(name, tel, address, monRent, status);
            houseRent.setPos(index, house1);
        }
    }
}
