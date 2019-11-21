package CT4;

import java.util.Scanner;

public class LessMoney {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while(caseNum-- >0){
            int inputLen = Integer.parseInt(cin.nextLine().trim());
            int[][] inArr = new int[inputLen][3];
            for(int i=0;i<inputLen;i++)
                inArr[i] = StringarrToIntarr(cin.nextLine().trim());
            int[][] DP = new int[inputLen][3];
            for(int j=0;j<3;j++)
                DP[0][j] = inArr[0][j];
            for(int i=1;i<inputLen;i++)
                for(int j=0;j<3;j++)
                    DP[i][j] = Math.min(DP[i-1][(j+1)%3],DP[i-1][(j+2)%3])+inArr[i][j];
            int minResult = Integer.MAX_VALUE;
            for(int j=0;j<3;j++)
                minResult = Math.min(minResult,DP[inputLen-1][j]);
            System.out.printf("%d\n",minResult);
        }
    }
    public static int[] StringarrToIntarr(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}