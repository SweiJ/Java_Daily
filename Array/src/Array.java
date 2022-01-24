import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  ���飺�����ͬ���ݵļ��ϡ��ڴ���������
 *  new��ʵ��������   �ڴ��ڶ���
 *  ջ�ϵĵ�ַ ���ò�����
 *  ���ϵĵ�ַ ���Դ�ӡ ���ǲ�����ʵ�� ͨ����ϣ���д���
 *
 *  foreach �Ǳ����������һ�ַ���
 * User: SweiJ
 * Date: 2021-10-18
 * Time: 15:28
 */
public class Array {
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        /* ����˳����� */
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        /* ���������ַ�����ʽ��� */
        System.out.println(Arrays.toString(array));

        for (int val: array) {
            System.out.print(val+" ");
        }

        printArr(array); // ��ӡ���� ��ֵ����

        int[] array2 = new int[]{11,22,33,44};
        int[] array3 = new int[4]; // ��ʼֵΪ0
        System.out.println(array);

        int[] array1 = null; // array���õ��Ǹ��ն��� ����0��ַ ������һ��null����Ԫ�ظ�ֵ����ȡ����
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

        /* ��ά���� */
        int[][] douarray = {{1,2,3},{4,5,6}}; // ��ʼ��ʱ���ܳ����������� ���������еĻ�����
        int[][] douarray1 = new int[][]{{1,2,3},{4,5,6}};
        int[][] douarray2 = new int[2][3];
        int[][] douarray3 = new int[2][];
        douarray3[0] = new int[]{1,2,3};
        douarray3[1] = new int[]{4,5};
        // ע�⣺C���� �ǿ���ָ���� ��Ҳ�����Զ��Ƶ�
        //      Java �б���ָ�� �п����Զ��Ƶ�

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
        System.out.println(Arrays.toString(douarray)); // ��ӡ��������ĵ�ַ
        System.out.println(Arrays.deepToString(douarray)); // ��ӡ���������Ԫ��
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
     * �÷����Ĳ�������������array�����ڴ��еĵ�ַ
     * ��ν��"����"������ֻ�Ǵ���һ����ַ��java�������趨���������ͣ������Ļ�
     * ������������������Σ�ֻ�ǽ�����ĵ�ַ���뵽�����β��У��������Ա����
     * ��������Ŀ�����������ܱȽϳ�����ô���������ͻ�ܴ�
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int x:arr) {
            System.out.print(x+" ");
        }
    }

    /**
     * ����Ŀ����� 4�ַ�ʽ��
     * 1.for
     * 2.Arrays.copyOf(array, array.length); ����һ���µĶ���
     * 3.System.arraycopy(array,0,ret,0,array.length);
     * ����arrayΪԴ���� 0ΪԴ������ʼλ�� retΪĿ������ 0ΪĿ��������ʼλ�� array.lenthΪ����
     * 4.array.clone() ��������������һ������ ���������Object�Ŀ�¡����
     * Object����������ĸ��ࡣ
     * ���϶���ǳ����
     * ǳ������
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
     * ���������е����ֵ
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
     * ���ֲ���
     * java �Դ��� Arrays.binarySearch(array, 8)
     * @param array
     * @param value
     * @return
     */
    public static int binSearch(int[] array, int value) {
        Arrays.sort(array); // ��������
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
     * ��������Ƿ�������
     * �ǣ�����true
     * �񣺷���false
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
