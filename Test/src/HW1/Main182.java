package HW1;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main182.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-11 23:07
 */
public class Main182 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int i = 0; i < caseNum; i++) {
            int[] a = StringarrToIntarr(cin.nextLine());
            int[] b = StringarrToIntarr(cin.nextLine());
            System.out.println(CloseToVal(a,b));
        }


    }

    public static int Sum(int[] arr) {
        int result = 0;
        for (int val : arr)
            result += val;
        return result;
    }

    public static int CloseToVal(int[] a, int[] b) {
        int adivide2 = (Sum(a) - Sum(b))/2;
        int index1 = 0,index2 = 0;
        int minVal = Math.abs(a[0] - b[0] - adivide2);
        while (true) {
            index1 = 0;index2 = 0;
            minVal = Math.abs(a[0] - b[0] - adivide2);
            for (int i = 0; i < a.length; i++)
                for (int j = 0;j < b.length; j++)
                    if (Math.abs(a[i] - b[j] - adivide2) < minVal) {
                        minVal = Math.abs(a[i] - b[j] - adivide2);
                        index1 = i;
                        index2 = j;
                    }
            if(Math.abs(Sum(a)-Sum(b))>Math.abs(Sum(a)-Sum(b)-2*a[index1]+2*b[index2])){
                int temp = a[index1];
                a[index1] = b[index2];
                b[index2] = temp;
                adivide2 = (Sum(a) - Sum(b))/2;
                continue;
            }
            break;
        }
        return Math.abs(Sum(a)-Sum(b));
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
