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
        book[0] = new Book("三国演义", "罗贯中", 23, "小说");
        book[1] = new Book("C语言程序设计", "谭浩强", 68, "IT");
        book[2] = new Book("Java程序设计", "高斯林", 78, "IT");
        book[3] = new Book("马克思主义基本原理概论", "本书编写组", 58, "哲学");
        this.usedSize = 4;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
    public int getUsedSize() {
        return usedSize;
    }

    /**
     * 寻找下标为pos的图书
     * @param pos
     * @return
     */
    public Book getPos(int pos) {
        return this.book[pos];
    }

    /**
     * 在pos位置增加图书
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
