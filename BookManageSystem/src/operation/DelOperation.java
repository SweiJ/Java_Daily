package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:41
 */
public class DelOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("ɾ��ͼ�飡");
        System.out.println("��������Ҫɾ����ͼ��");
        String name = scanner.nextLine();

        int index = 0;
        int size = bookList.getUsedSize();
        int i = 0;
        for (; i < size; i++) {
            Book book = bookList.getPos(i);
            if(book.getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(i >= size) {
            System.out.println("û����Ҫɾ����ͼ�飡");
            return;
        }
        for (int j = index; j < size - 1; j++) {
            Book current_book = bookList.getPos(j + 1);
            bookList.setBook(j, current_book);
        }
        bookList.setBook(size - 1, null);
        bookList.setUsedSize(size - 1);
        System.out.println("ɾ���ɹ���");
    }
}
