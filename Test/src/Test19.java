import javax.rmi.CORBA.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-22
 * Time: 15:03
 */
public class Test19 {
    static void fun(int[] arr, int k) {
        if(k == 1) {
            return;
        }
        fun(arr, k - 1);

        int target = arr[k];
        int j = k;
        while (j > 0 && target < arr[j - 1])
        {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = target;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,27,35,25,25,2,6,6,7};
//        int i, j;
//        int n = arr.length;
//        int target;

        fun(arr, arr.length - 1);
        //�ٶ���һ��Ԫ�ر��ŵ�����ȷ��λ����
        //�������������1 - n-1
//        for (i = 1; i < n; i++)
//        {
//            j = i;
//            target = arr[i];
//
//            while (j > 0 && target < arr[j - 1])
//            {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//
//            arr[j] = target;
//        }
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
    }
    /**
     * ������ֻ��һ��������һ�Σ�����������k�Σ��ҳ�����һ�ε���
     *     1.��ͬ����������λ�ӷ�
     *     2.2����ͬ�Ķ�����������λ�ӷ���0
     *     3.10����ͬ��ʮ����������λ�ӷ���0
     *     4.k����ͬ��k����������λ�ӷ���0
     *  ˼·��
     *      1�����Ƚ������е�Ԫ�ػ���k����ͨ��ʹ�ã�Integer.toString(i, radix);
     *      2������Щ��������λ�ӷ����Ľ��Ϊ����һ�ε�����
     */
    public static void main6(String[] args) {
        // 10ת����3����
        System.out.println(Integer.toString(10, 3));
//        int[] arr = {1,1,1,3,3,3,4,4,4,7,8,8,8};
//        Map map = new HashMap();
//        for (int i = 0; i < arr.length; i++) {
//            if(map.get(arr[i]))
//            map.put(arr[i], 0);
//
//        }
    }
    // ������С��
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double n = scanner.nextDouble();
        StringBuilder sb = new StringBuilder("0.");
        while(n > 0) {
            double r = n*2;
            if(r >= 1) {
                // ������������
                sb.append("1");
                n = r - 1;
            } else {
                sb.append("0");
                n = r;
            }
            if(sb.length() > 34) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb);
    }
    // ��������żλ����
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // ȡ��ż��λ
        int even = n&0xaaaaaaaa;
        // ȡ������λ
        int old = n&0x55555555;
        // ż��λ���� ����λ����
        int result = (even>>1)^(old<<1);
        System.out.println(result);
    }
    // ��ǰ���Ƿ���2�������η�
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if((n^(n-1)) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    // �������к��ж��ٸ�1
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while(n != 0) {
            n &= (n-1);
            count++;
        }
        System.out.println(count);
    }
    // 1-1000֮����һ���ظ��������ҳ��������
    public static void main1(String[] args) {
        int n = 1001;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i+1;
        }
        arr[arr.length - 1] = new Random().nextInt(n);

        int x = 0;
        for (int i = 1; i < n; i++) {
            x ^= i;
        }
        for (int i = 0; i < n; i++) {
            x ^= arr[i];
        }
        System.out.println(x);
    }
}
