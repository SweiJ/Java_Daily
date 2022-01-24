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
    //��Ч�����ݸ���
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[10];
    }

    // ��ӡ˳���
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // ��ȡ˳������Ч���ݳ���
    public int size() {
        return this.usedSize;
    }

    // �� pos λ������Ԫ��
    public void add(int pos, int data) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("λ�ô���");
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

    // �ж��Ƿ����ĳ��Ԫ��
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    
    // ����ĳ��Ԫ�ض�Ӧ��λ��
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // ��ȡ pos λ�õ�Ԫ��
    public int getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("λ�ô���");
            return -1;
        }
        if(isEmpty()) {
            System.out.println("˳���Ϊ�գ�");
            return  -1;
        }
        return this.elem[pos];
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    // �� pos λ�õ�Ԫ����Ϊ value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("λ�ô���");
            return;
        }
        if(isEmpty()) {
            System.out.println("˳���Ϊ�գ�");
            return;
        }
        this.elem[pos] = value;
    }
    //ɾ����һ�γ��ֵĹؼ���key
    public void remove(int toRemove) {
        if(isEmpty()) {
            System.out.println("˳���Ϊ�գ�");
            return;
        }
        int index = search(toRemove);
        if(index == -1) {
            System.out.println("û����Ҫɾ�������֣�");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }
    // ���˳���
    public void clear() {
        if(isEmpty()) {
            System.out.println("˳���Ϊ�գ�");
            return;
        }
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = 0;
        }
        this.usedSize = 0;
    }
}
