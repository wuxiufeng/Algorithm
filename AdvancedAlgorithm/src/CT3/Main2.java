package CT3;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main2.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-10-31 09:33
 */
public class Main2 {
    public static int[] StringToIntarr(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }

    // Driver program to test above function
    static public void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            int[] input1 = StringToIntarr(cin.nextLine().trim());
            int[] input2 = StringToIntarr(cin.nextLine().trim());
            int[] input3 = StringToIntarr(cin.nextLine().trim());
            for (int i = 0; i < input3.length; i++) {
                int currCount = 0;
                for (int j = 0; j < input2.length; j++)
                    if (input2[j] % input3[i] == 0)
                        currCount++;
                if (i == 0)
                    System.out.printf("%d", currCount);
                else
                    System.out.printf(" %d", currCount);
            }
            System.out.printf("%n");
        }
    }
}
