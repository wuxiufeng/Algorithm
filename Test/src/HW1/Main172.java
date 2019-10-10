package HW1;

/**
 * @program: Test
 * @ClassName Main17.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-11 00:08
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main172 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            System.out.println(getNum(StringarrToIntarr(cin.nextLine()), Integer.parseInt(cin.nextLine().trim())));
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

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0,maxV,minV;
        for(int i=0;i<arr.length-1;i++) {
            maxV = arr[i];
            minV = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j]>maxV)
                    maxV=arr[j];
                if(arr[j]<minV)
                    minV=arr[j];
                if(maxV-minV>num){
                    res+=arr.length-j;
                    break;
                }
            }
        }
        return res;
    }
}