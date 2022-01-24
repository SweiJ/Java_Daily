package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-18
 * Time: 22:42
 */
public class FindOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书！");
        System.out.println("请输入你要查找图书的书名：");
        String name = scanner.nextLine();
        int size = bookList.getUsedSize();
        int i = 0;
        for (; i < size; i++) {
            if(bookList.getPos(i).getName().equals(name)) {
                System.out.println(bookList.getPos(i).toString());
                return;
            }
        }
        System.out.println("没有找到该图书！");
    }
}
