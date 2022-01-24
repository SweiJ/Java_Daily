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
        System.out.println("---------------���ݳ���ϵͳ---------------");
        System.out.println("             1���� �� �� Դ               ");
        System.out.println("             2���� �� �� ��               ");
        System.out.println("             3��ɾ �� �� ��               ");
        System.out.println("             4���� �� �� �� �� Ϣ          ");
        System.out.println("             5���� �� �� ��               ");
        System.out.println("             0����      ��               ");
        System.out.println("----------------------------------------");
        System.out.println("��ѡ��>");
        int choice = scanner.nextInt();
        scanner.nextLine();
        iOperations[choice].work(houseRent);
    }
}
