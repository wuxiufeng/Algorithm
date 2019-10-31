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
    public static void main (String[] args) {
        String[] unit = {"1","2","3","4","5","$","5","4","3","2","1"};

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int query = sc.nextInt();

            while (query > unit.length) {
                double[] domainInfo = domainInfo(query);
                double domainStart = ((domainInfo[0] - domainInfo[1]) / 2 ) +  domainInfo[1];

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

    public static double[] domainInfo(int query) {
        double domainSize = 5;
        double ith = 0;

        while(true) {
            if (query <= domainSize) {
                return new double[]{domainSize, ith};
            }
            ith++;
            domainSize = (domainSize * 2) + ith;
        }
    }
}