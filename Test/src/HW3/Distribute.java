package HW3;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Distribute.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-18 21:12
 */
public class Distribute {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while (caseNum > 0) {
            int n = Integer.parseInt(cin.nextLine().trim());
            int[][] cost = new int[n+1][n+1];
            for(int i=0;i<=n;i++)
                for (int j=0;j<=n;j++)
                    cost[i][j] =-1;
            String[] input = cin.nextLine().trim().split(",");
            int[] tocost = null;
            for(int i=0;i<input.length;i++){
                tocost = StringToIntarr(input[i]);
                cost[tocost[0]][tocost[1]] = tocost[2];
            }
            for(int i=0;i<=n;i++) {
                for (int j = 0; j <= n; j++)
                    System.out.printf("%d ", cost[i][j]);
                System.out.printf("\n");
            }
            --caseNum;
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
