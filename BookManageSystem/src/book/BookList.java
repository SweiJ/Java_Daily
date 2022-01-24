package book;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 21:26
 */
public class BookList {
    private Book[] book = new Book[10];
    private int usedSize;

    public BookList() {
        book[0] = new Book("��������", "�޹���", 23, "С˵");
        book[1] = new Book("C���Գ������", "̷��ǿ", 68, "IT");
        book[2] = new Book("Java�������", "��˹��", 78, "IT");
        book[3] = new Book("���˼�������ԭ�����", "�����д��", 58, "��ѧ");
        this.usedSize = 4;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
    public int getUsedSize() {
        return usedSize;
    }

    /**
     * Ѱ���±�Ϊpos��ͼ��
     * @param pos
     * @return
     */
    public Book getPos(int pos) {
        return this.book[pos];
    }

    /**
     * ��posλ������ͼ��
     * @param pos
     * @param book
     * @return
     */
    public Book addPos(int pos, Book book) {
        return this.book[pos] = book;
    }

    public Book[] getBook() {
        return book;
    }

    public void setBook(int pos, Book book) {
        this.book[pos] = book;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "book=" + Arrays.toString(book) +
                '}';
    }
}
