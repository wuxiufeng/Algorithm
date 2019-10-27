package HW2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main4.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-27 11:47
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = cin.nextInt();
        for (int curi = 0; curi < caseNum; curi++) {
            double[] input = new double[cin.nextInt()];
            for (int j = 0; j < input.length; j++)
                input[j] = cin.nextDouble();
            Arrays.sort(input);
            for (int j = 0; j < input.length - 1; j++)
                System.out.printf("%.0f ",input[j]);
            System.out.printf("%.0f%n",input[input.length-1]);
        }
    }
}
