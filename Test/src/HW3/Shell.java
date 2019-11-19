package HW3;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Shell.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-18 20:15
 */
public class Shell {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine());
        while (caseNum > 0) {
            int[] input = StringToIntarr(cin.nextLine().trim());
            int[] slice = StringToIntarr(cin.nextLine().trim());
            for (int i = 0; i < slice.length; i++) {
                PartialSort(input, slice[i]);
            }
            for (int i = 0; i < input.length - 1; i++)
                System.out.printf("%d ", input[i]);
            System.out.printf("%d\n", input[input.length - 1]);
            --caseNum;
        }

    }

    public static void PartialSort(int[] inArr, int sli) {
        boolean flag = true;
        for (int i = 0; i < sli; i++) {
            if (i + sli >= inArr.length)
                return;
            flag = true;
            while (flag) {
                flag = false;
                for (int j = i + sli; j < inArr.length; j += sli) {
                    if (inArr[j] < inArr[j - sli]) {
                        int temp = inArr[j];
                        inArr[j] = inArr[j - sli];
                        inArr[j - sli] = temp;
                        flag = true;
                    }
                }
            }
        }

    }

    public static int[] StringToIntarr(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}
