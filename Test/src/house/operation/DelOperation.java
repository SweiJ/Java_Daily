package house.operation;

import house.house.HouseRent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 23:10
 */
public class DelOperation implements IOperation{
    @Override
    public void work(HouseRent houseRent) {
        System.out.println("������绰��>");
        String tel = scanner.nextLine();
        int size = houseRent.getUseSize();
        int i = 0;
        for (i = 0; i < size; i++) {
            if(houseRent.getPos(i).getTel().equals(tel)) {
                for (int j = i; j < size - 1; j++) {
                    houseRent.setPos(j, houseRent.getPos(j+1));
                }
                houseRent.remove(size);
                houseRent.setUseSize(size - 1);
                System.out.println("ɾ���ɹ���");
                break;
            }
        }
        if(i >= size) {
            System.out.println("û����Ҫɾ���ķ�����Ϣ��");
        }
    }
}
