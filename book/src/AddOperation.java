/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-15
 * Time: 21:02
 */
public class AddOperation implements IOperation {

    public void work(BookList bookList) {
        System.out.println("新增图书！");

    }
    public void work(BookList bookList) {
        System.out.println("查找图书！");
        String name = scanner.nextLine();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);
            if(name.equals(book.getName())) {
                System.out.println("找到了这本书，信息如下：");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有找到这本书！");
    }
    public class DelOperation implements IOperation{
        public void work(BookList bookList) {
            System.out.println("删除图书！");
//1、根据书名找到书的位置 index
// 2、进行删除
            String name = scanner.nextLine();
            int size = bookList.getUsedSize();
            for (int i = 0; i < size; i++) {
                Book book = bookList.getPos(i);
                if(name.equals(book.getName())) {
                    System.out.println("找到了这本书，信息如下：");
                    System.out.println(book);
                    return;
                }
            }
        }
    }
}
