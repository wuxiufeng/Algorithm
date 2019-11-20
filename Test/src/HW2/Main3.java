package HW2;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName CT1.Main3.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-27 12:40
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            String[] input = cin.nextLine().trim().split(" ");
            int slice = Integer.parseInt(input[input.length - 1]);
            for (int i = 1; i < input.length - 1; i += slice) {
                if (i + slice - 1 < input.length - 1) {
                    for (int j = i + slice - 1; j >= i; j--)
                        if (i == 1 && j == slice)
                            System.out.print(input[j]);
                        else
                            System.out.print(" " + input[j]);
                } else {
                    for (int j = i; j < input.length - 1; j++)
                        if (j == 1)
                            System.out.print(input[j]);
                        else
                            System.out.print(" " + input[j]);
                }
            }
            System.out.println();
        }
    }
}
