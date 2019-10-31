package CT3;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main3.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-10-31 10:02
 */

public class Main3 {
    static char[] a = {'1', '2', '3', '4', '5', '$', '5', '4', '3', '2', '1'};

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            long n = sc.nextLong();

            if (n == 0)
                System.out.println();
            else {

                findOut(n);

            }

        }
    }

    public static void findOut(long n) {

        if (n <= 11)
            System.out.println(a[(int) (n - 1)]);
        else {
            int total = 5, last = -1;
            int dc = 0;
            while (total <= n) {

                dc++;
                last = total;
                total = 2 * total + dc;

            }
            int rem = (int) (n - last);
            if (rem == 0)
                System.out.println(1);
            else if (rem <= dc)
                System.out.println('$');
            else {

                rem -= dc;
                if (rem <= 11)
                    System.out.println(a[rem - 1]);
                else
                    findOut(n - (last + dc));

            }
        }

    }

}