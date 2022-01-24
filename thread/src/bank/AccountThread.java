package bank;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 16:58
 */
public class AccountThread extends Thread {
    Account account = null;
    public AccountThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(10000);
        System.out.println(Thread.currentThread().getName() + account.getAccount() + " " + account.getBalance());
    }
}
