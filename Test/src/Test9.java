import org.omg.CosNaming.BindingIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-05
 * Time: 21:58
 */
@SuppressWarnings("all")
public class Test9 {
    public static void main(String[] args) {
        Car1 car1 = new Car1("����", 400000);
        Car1 car2 = new Car1("��˹����", 5000000);
        ArrayList<Car1> arrayList = new ArrayList<>();
        ArrayList<Car1> arrayList1 = new ArrayList<>();
        arrayList1.add(car1);
        arrayList1.add(car2);

        arrayList.add(car1); // ��ӵ���Ԫ��
        arrayList.remove(0); // ɾ��ָ��Ԫ��
        arrayList.contains(car1); // ����Ԫ���Ƿ����
        arrayList.size(); // ��ȡԪ�ظ���
        arrayList.isEmpty(); // �ж��Ƿ�Ϊ��
        arrayList.clear(); // ���
        arrayList.addAll(arrayList1); // ��Ӷ��Ԫ��
        arrayList.containsAll(arrayList1); // ���Ҷ��Ԫ���Ƿ񶼴���
        arrayList.removeAll(arrayList1); // ɾ�����Ԫ��

        Iterator<Car1> iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
            Car1 next =  iterator.next();
            System.out.println(next);
        }

        for (Object car : arrayList1) {
            System.out.println(car);
        }

    }
}
class Car1 {
    private String name;
    private long price;

    public Car1(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car1{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
