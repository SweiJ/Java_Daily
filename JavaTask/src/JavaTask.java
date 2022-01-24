import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdk.internal.dynalink.beans.StaticClass;

import java.awt.*;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-10-19
 * Time: 19:25
 */
public class JavaTask {
    public static void primeJudge(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 2;
        for (; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                System.out.println(num + "不是素数");
                break;
            }
        }
        if(i > Math.sqrt(num)) {
            System.out.println(num + "是素数");
        }
    }

    public static void nineNum(String[] args) {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 10 == 9) {
                count++;
            }
            if(i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void leapYear(String[] args) {
        for (int year = 1000; year < 2000; year++) {
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.print(year + " ");
            }
        }
        System.out.println("是闰年");
    }

    public static void greatCommon(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int temp = x % y;

        while(temp != 0) {
            x = y;
            y = temp;
            temp = x % y;
        }
        System.out.println("最大公约数" + y);
    }

    public static void decimalsSum(String[] args) {
        double sum = 0.0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum += 1.0 / i * flag;
            flag = -flag;
        }
        System.out.println(sum);
    }

    public static void prime(String[] args) {
        int flag = 1;
        for (int i = 1; i < 100; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) {
                System.out.print(i + " ");
            }
            flag = 1;
        }
    }

    public static void ageJudge(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n <= 18) {
            System.out.println("少年");
        } else if(19 <= n && n <= 28) {
            System.out.println("青年");
        } else if(29 <= n && n <= 55) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }

    public static void passwordJudge(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while(count != 0) {
            System.out.println("请输入密码：");
            String password = scanner.nextLine();
            if(password.equals("123456")) {
                System.out.println("输入正确！");
                break;
            } else {
                count--;
                System.out.println("密码错误，你还有" + count + "次机会！");
            }
        }
    }

    public static void guessNumber(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomnum = random.nextInt(100);
        while(true) {
            int guessnum = scanner.nextInt();
            if(guessnum > randomnum) {
                System.out.println("猜大了！");
            } else if(guessnum < randomnum) {
                System.out.println("猜小了！");
            } else {
                System.out.println("猜对了！");
                break;
            }
        }
    }

    public static void narciNumber(String[] args) {
        for (int i = 3; i < 1000; i++) {
            if(i == Math.pow(i % 10, 3) + Math.pow(i / 10 % 10, 3) + Math.pow(i / 100, 3)) {
                System.out.println(i);
            }
        }
    }

    public static void graph(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(j == n - i - 1 || i == j) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void binary(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 0;
        while(n != 0) {
            int temp = n % 2;
            n = n / 2;
            if((temp ^ 1) == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void binary1(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        System.out.println(count);
    }

    public static void binary2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n - 1);
        }
    }

    public static void numrecursion(int num) {
        if(num == 0)
            return;
        else {
            numrecursion(num / 10);
            System.out.print(num % 10 + " ");
        }
    }
    public static void numoutput(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        numrecursion(n);
    }

    public static void multipleTable(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }

    public static void oncenum(String[] args) {
        int[] a = {1,2,3,4,4,3,2,1,6};

        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp ^= a[i];
        }
        System.out.println(temp);
    }

    public static int fib(int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
          return  fib(n - 1) + fib(n - 2);
        }
    }
    public static void fibmain(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(fib(n));
    }

    public static void fatorsum(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int fator = 1, sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                fator *= j;
            }
            sum += fator;
            fator = 1;
        }
        System.out.println(sum);
    }

    public static void fator(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int fator = 1;
        for (int i = 1; i <= n; i++) {
            fator *= i;
        }
        System.out.println(fator);
    }

    public static void oddeven(String[] args) {
        int[] a = {1,12,24,32,323,5,5,32,51};
        int left = 0;
        int right = a.length - 1;
        while(left < right) {
            while(left < right && a[left] % 2 != 0) {
                left++;
            }
            while(left < right && a[right] % 2 == 0) {
                right--;
            }
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public static int max2(int a, int b) {
        return a > b ? a : b;
    }

    public static int max3(int a, int b, int c) {
        return max2(a, b) > c ? max2(a, b) : c;
    }

    public static void comparenum(String[] args) {
        System.out.println(max2(10, 20));
        System.out.println(max3(12, 32, 10));
    }

    public static int nummax(int a, int b) {
        return a > b ? a : b;
    }
    public static double nummax(double a, double b) {
        return a > b ? a : b;
    }
    public static double nummax(double a, double b, int c) {
        return nummax(a, b) > c ? nummax(a, b) : c;
    }
    public static void numMax(String[] args) {
        System.out.println(nummax(12.4, 34.5));
        System.out.println(nummax(12.4, 33.5, 23));
    }

    public static int sum(int a, int b) {
        return a + b;
    }
    public static double sum(double a, double b, double c) {
        return a + b + c;
    }

    public static void numSum(String[] args) {
        System.out.println(sum(12, 23));
        System.out.println(sum(34.3, 34.3, 5.4));
    }

    public static void binaryoddeven(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 30; i >= 0; i-=2) {
            System.out.print((n >>> i) & 1);
        }
        System.out.println();
        for (int i = 31; i >= 1; i-=2) {
            System.out.print((n >>> i) & 1);
        }
    }

    public static void func(int n) {
        if(n == 0)
            return;
        else {
            func(n / 10);
            System.out.print(n % 10 + " ");
        }
    }

    public static int Sum(int n) {
        if(n == 1) {
            return 1;
        }else {
            return Sum(n - 1) + n;
        }
    }


    public static int factor(int n) {
        if(n == 1) {
            return 1;
        }else {
            return n * factor(n - 1);
        }
    }

    public static int jumpStep(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return jumpStep(n - 1) + jumpStep(n - 2);
    }
    public static void jumpmain(String[] args) {
        System.out.println(jumpStep(7));
    }


    public static int integerSum(int n) {
        if(n < 10)
            return n;
        else {
            return integerSum(n / 10) + n % 10;
        }
    }
    public static void integerSummain(String[] args) {
        System.out.println(integerSum(1234));
    }

    public static void hanoi(int n, char a, char b, char c) {
        if(n == 1)
            changehannoi(a, c);
        else {
            hanoi(n - 1, a, c, b);
            changehannoi(a, c);
            hanoi(n - 1, b, a, c);
        }
    }
    public static void changehannoi(char a, char b) {
        System.out.println(a + "->" + b);
    }
    public static void hanoimain(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        hanoi(n, 'A', 'B', 'C');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();
        System.out.println(n.add(m));
    }
}
