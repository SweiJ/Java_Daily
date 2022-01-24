package bank;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 16:55
 */
public class Account {
    private String account;
    private int balance;

    public Account(String account, int balance) {
        this.account = account;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", balance=" + balance +
                '}';
    }

    // È¡¿î
    public void withdraw(int withdraw) {
        synchronized (this) {
            int before = this.balance;
            int last = before - withdraw;
            this.balance = last;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

