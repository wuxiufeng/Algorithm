package HW2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Cow.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-27 11:54
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int[] input = StringarrToIntarr(cin.nextLine().trim());
            Arrays.sort(input);
            for (int j = 0; j < input.length - 1; j++)
                System.out.print(input[j] + " ");
            System.out.println(input[input.length - 1]);
        }
    }

    /**
     * @param string
     * @return int[]
     * @throws
     * @title StringarrToIntarr
     * @description
     * @author Mr. jun
     * @updateTime 2019/10/10 9:20
     */
    public static int[] StringarrToIntarr(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}
