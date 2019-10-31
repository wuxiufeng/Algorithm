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
    public static void main(String[] args) {
        String[] unit = {"1", "2", "3", "4", "5", "$", "5", "4", "3", "2", "1"};

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int query = sc.nextInt();

            while (query > unit.length) {
                int[] domainInfo = domainInfo(query);
                int domainStart = ((domainInfo[0] - domainInfo[1]) / 2) + domainInfo[1];

                if (query <= domainStart) {
                    query = 6; //$
                    break;
                }
                query -= domainStart;
            }
            System.out.println(query > 0 ? unit[query - 1] : "");
            t--;
        }
    }

    public static int[] domainInfo(int query) {
        int domainSize = 5;
        int ith = 0;

        while (true) {
            if (query <= domainSize) {
                return new int[]{domainSize, ith};
            }
            ith++;
            domainSize = (domainSize * 2) + ith;
        }
    }
}
