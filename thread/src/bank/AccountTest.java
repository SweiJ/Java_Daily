package bank;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 17:00
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acc1 = new Account("acc-01", 200000);

        Thread thread1 = new AccountThread(acc1);
        Thread thread2 = new AccountThread(acc1);

        thread1.start();
        thread2.start();


    }
}
