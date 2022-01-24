import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-10-31
 * Time: 21:17
 */
public class MyArrayList {

    public int[] elem;
    //有效的数据个数
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[10];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 获取顺序表的有效数据长度
    public int size() {
        return this.usedSize;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("位置错误！");
            return;
        }
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }

        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("位置错误！");
            return -1;
        }
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return  -1;
        }
        return this.elem[pos];
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("位置错误！");
            return;
        }
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        int index = search(toRemove);
        if(index == -1) {
            System.out.println("没有你要删除的数字！");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }
    // 清空顺序表
    public void clear() {
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = 0;
        }
        this.usedSize = 0;
    }
}
