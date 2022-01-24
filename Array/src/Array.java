import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  数组：存放相同数据的集合。内存是连续的
 *  new：实例化对象   内存在堆上
 *  栈上的地址 是拿不到的
 *  堆上的地址 可以打印 但是不是真实的 通过哈希进行处理
 *
 *  foreach 是遍历数组的另一种方法
 * User: SweiJ
 * Date: 2021-10-18
 * Time: 15:28
 */
public class Array {
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        /* 数组顺序输出 */
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        /* 将数组以字符串形式输出 */
        System.out.println(Arrays.toString(array));

        for (int val: array) {
            System.out.print(val+" ");
        }

        printArr(array); // 打印数组 按值传递

        int[] array2 = new int[]{11,22,33,44};
        int[] array3 = new int[4]; // 初始值为0
        System.out.println(array);

        int[] array1 = null; // array引用的是个空对象 不是0地址 不能向一个null数组元素赋值，获取长度
        System.out.println(array1);

        for (int x : copyArray(array)) {
            System.out.print(x+" ");
        }

        int[] arrayret = copyArray(array);
        System.out.println(Arrays.toString(arrayret));

        Arrays.copyOf(array, array.length);

        System.out.println(maxArray(array));

        System.out.println(binSearch(array, 8));

        System.out.println(Arrays.binarySearch(array, 8));

        System.out.println(isUp(array));

        /* 二维数组 */
        int[][] douarray = {{1,2,3},{4,5,6}}; // 初始化时不能出现行列数字 必须有行列的花括号
        int[][] douarray1 = new int[][]{{1,2,3},{4,5,6}};
        int[][] douarray2 = new int[2][3];
        int[][] douarray3 = new int[2][];
        douarray3[0] = new int[]{1,2,3};
        douarray3[1] = new int[]{4,5};
        // 注意：C语言 是可以指定列 行也可以自动推导
        //      Java 行必须指定 列可以自动推导

        for (int i = 0; i < douarray.length; i++) {
            for (int j = 0; j < douarray[i].length; j++) {
                System.out.println(douarray[i][j]+" ");
            }
            System.out.println();
        }

        for (int[] tmp : douarray) {
            for (int tmp1 : tmp) {
                System.out.println(tmp1 + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(douarray)); // 打印的是数组的地址
        System.out.println(Arrays.deepToString(douarray)); // 打印的是数组的元素
    }

    public static String myToString(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if(i < array.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(myToString(array));
    }

    /**
     * 该方法的参数引用了数组array的在内存中的地址
     * 所谓的"引用"本质上只是存了一个地址，java将数组设定成引用类型，这样的话
     * 后续进行数组参数传参，只是将数组的地址传入到函数形参中，这样可以避免对
     * 整个数组的拷贝（数组可能比较长，那么拷贝开销就会很大）
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int x:arr) {
            System.out.print(x+" ");
        }
    }

    /**
     * 数组的拷贝有 4种方式：
     * 1.for
     * 2.Arrays.copyOf(array, array.length); 返回一个新的对象
     * 3.System.arraycopy(array,0,ret,0,array.length);
     * 参数array为源数组 0为源数组起始位置 ret为目标数组 0为目标数组起始位置 array.lenth为长度
     * 4.array.clone() 产生了这个对象的一个副本 这个方法是Object的克隆方法
     * Object：是所有类的父类。
     * 以上都是浅拷贝
     * 浅拷贝：
     * @param array
     * @return
     */
    public static int[] copyArray(int[] array) {
//        int[] ret = new int[array.length];
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }

//        int[] ret1 = Arrays.copyOf(array, array.length);
//        int[] ret2 = new int[array.length];
//        System.arraycopy(array,0,ret,0,array.length);
//        int[] ret3 = array.clone();

        return ret;
    }

    /**
     * 查找数组中的最大值
     * @param array
     * @return
     */
    public static int maxArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    /**
     * 二分查找
     * java 自带的 Arrays.binarySearch(array, 8)
     * @param array
     * @param value
     * @return
     */
    public static int binSearch(int[] array, int value) {
        Arrays.sort(array); // 数组排序
        int right = array.length - 1, left = 0;
        int mid = (right + left) / 2;
        while(left <= right) {
            if(value > array[mid]) {
                left = mid + 1;
            } else if(value < array[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (right + left) / 2;
        }
        return -1;
    }

    /**
     * 检查数组是否是升序
     * 是：返回true
     * 否：返回false
     * @param array
     * @return
     */
    public static boolean isUp(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void twoDimensionalArray(String[] args) {

    }
}
