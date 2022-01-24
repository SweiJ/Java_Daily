/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-08
 * Time: 21:58
 */
@SuppressWarnings("all")
public class Test15 {
    public static void main(String[] args) {
//        SellTicket sellTicket1 = new SellTicket();
//        SellTicket sellTicket2 = new SellTicket();
//        SellTicket sellTicket3 = new SellTicket();
//
//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
    }
}
class SellTicket extends Thread {
    private static int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "还剩" + (--ticketNum) + "张票");
            if(ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
        }
    }
}
