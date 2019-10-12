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
public class Main183 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int i = 0; i < caseNum; i++) {
            CloseToVal(StringarrToIntarr(cin.nextLine()+" "+cin.nextLine()));
        }


    }

    public static int Sum(int[] arr) {
        int result = 0;
        for (int val : arr)
            result += val;
        return result;
    }

    public static void CloseToVal(int[] arr) {
        boolean[][] dp = new boolean[arr.length/2][Sum(arr)/2];
        for(int i=0;i<arr.length;i++)
            for(int j=Math.min(i,arr.length/2);j>=1;j--)
                for(int s = 1;s<=Sum(arr)/2;s++)
                    if(s>=arr[i]&&dp[j-1][s-arr[i]])
                        dp[j][s] = true;
        int s = Sum(arr)/2;
        for(;s>=1&&!dp[arr.length/2][s];s--);
        System.out.println(Sum(arr)-2*s);

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
