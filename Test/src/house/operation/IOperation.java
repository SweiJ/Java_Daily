package house.operation;

import house.house.HouseRent;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-01
 * Time: 10:09
 */
public interface IOperation {
    Scanner scanner = new Scanner(System.in);
    void work(HouseRent houseRent);
}
