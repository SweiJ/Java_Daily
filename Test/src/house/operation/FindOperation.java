package house.operation;

import house.house.HouseRent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 23:11
 */
public class FindOperation implements IOperation {
    @Override
    public void work(HouseRent houseRent) {
        System.out.println("请输入电话：>");
        String tel = scanner.nextLine();
        int size = houseRent.getUseSize();
        int i = 0;
        for (i = 0; i < size; i++) {
            if(houseRent.getPos(i).getTel().equals(tel)) {
                System.out.println(houseRent.getPos(i));
                break;
            }
        }
        if(i >= size) {
            System.out.println("没有你要查询的房屋信息！");
        }
    }
}
