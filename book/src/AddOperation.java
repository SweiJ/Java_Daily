/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-15
 * Time: 21:02
 */
public class AddOperation implements IOperation {

    public void work(BookList bookList) {
        System.out.println("����ͼ�飡");

    }
    public void work(BookList bookList) {
        System.out.println("����ͼ�飡");
        String name = scanner.nextLine();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);
            if(name.equals(book.getName())) {
                System.out.println("�ҵ����Ȿ�飬��Ϣ���£�");
                System.out.println(book);
                return;
            }
        }
        System.out.println("û���ҵ��Ȿ�飡");
    }
    public class DelOperation implements IOperation{
        public void work(BookList bookList) {
            System.out.println("ɾ��ͼ�飡");
//1�����������ҵ����λ�� index
// 2������ɾ��
            String name = scanner.nextLine();
            int size = bookList.getUsedSize();
            for (int i = 0; i < size; i++) {
                Book book = bookList.getPos(i);
                if(name.equals(book.getName())) {
                    System.out.println("�ҵ����Ȿ�飬��Ϣ���£�");
                    System.out.println(book);
                    return;
                }
            }
        }
    }
}
