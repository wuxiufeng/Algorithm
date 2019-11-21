package HW1.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main13.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 09:49
 */
public class Main13 {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int[] input,subInput;
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for(int i=0;i<caseNum;i++){
            input = StringarrToIntarr(cin.nextLine());
            int[] index12 = StringarrToIntarr(cin.nextLine());
            subInput = Arrays.copyOfRange(input,index12[0]-1,index12[1]);
            Arrays.sort(subInput);
            System.out.println(subInput[Integer.parseInt(cin.nextLine().trim())-1]);
        }
    }
    /**
     * @title StringarrToIntarr
     * @description
     * @author Mr. jun
     * @param string
     * @return int[]
     * @throws
     * @updateTime 2019/10/10 9:20
     */
    public static int[] StringarrToIntarr(String string){
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for(int j=0;j<inputS.length;j++){
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}

