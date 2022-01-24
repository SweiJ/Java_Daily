package TestDemo.KeyWord;

import extendTest.Desk;
import extendTest.Plant;
import extendTest.Wood;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-02
 * Time: 17:56
 */
public class ploTest {
    public static void main(String[] args) {
        Wood wood = new Desk();
        Plant plant = wood.get();
        System.out.println(plant);
    }
}
