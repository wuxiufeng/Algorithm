package CT2;

/**
 * @program: Test
 * @ClassName Main17.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-11 00:08
 */

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            long[] input = StringarrToIntarr(cin.nextLine().trim());
            System.out.println(getNum(input));
        }
    }

    public static long getNum(long[] arr) {
        long result = 1;
        while(arr[1]!=1){
            if(arr[1]%2==1){
                result = result*arr[0];
                result = result%arr[2];
            }
            arr[0] = arr[0]*arr[0];
            arr[0] = arr[0]%arr[2];
            arr[1] = arr[1]/2;
        }
        return (result*arr[0])%arr[2];
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
    public static long[] StringarrToIntarr(String string) {
        String[] inputS = string.split(" ");
        long[] output = new long[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}