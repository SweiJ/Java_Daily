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
        System.out.println("������绰��>");
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
            System.out.println("û����Ҫ�޸ĵķ�����Ϣ��");
        } else {
            System.out.println("������������>");
            String name = scanner.nextLine();
            System.out.println("������绰��>");
            String tel = scanner.nextLine();
            System.out.println("�������ַ��>");
            String address = scanner.nextLine();
            System.out.println("���������⣺>");
            String monRent = scanner.nextLine();
            System.out.println("������״̬��>");
            boolean status = scanner.nextBoolean();
            House house1 = new House(name, tel, address, monRent, status);
            houseRent.setPos(index, house1);
        }
    }
}
