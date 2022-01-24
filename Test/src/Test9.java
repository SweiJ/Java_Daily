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
        Car1 car1 = new Car1("宝马", 400000);
        Car1 car2 = new Car1("阿斯顿马丁", 5000000);
        ArrayList<Car1> arrayList = new ArrayList<>();
        ArrayList<Car1> arrayList1 = new ArrayList<>();
        arrayList1.add(car1);
        arrayList1.add(car2);

        arrayList.add(car1); // 添加单个元素
        arrayList.remove(0); // 删除指定元素
        arrayList.contains(car1); // 查找元素是否存在
        arrayList.size(); // 获取元素个数
        arrayList.isEmpty(); // 判断是否为空
        arrayList.clear(); // 清空
        arrayList.addAll(arrayList1); // 添加多个元素
        arrayList.containsAll(arrayList1); // 查找多个元素是否都存在
        arrayList.removeAll(arrayList1); // 删除多个元素

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
