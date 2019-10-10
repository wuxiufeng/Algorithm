package HW1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main14.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 10:13
 */
public class Main14 {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        int[] input;
        int result,target;
        for(int i=0;i<caseNum;i++){
            input = StringarrToIntarr(cin.nextLine());
            Arrays.sort(input);
            target = Integer.parseInt(cin.nextLine().trim());
            result = 0;
            for(int j=0;j<input.length-1;j++)
                for(int k=j+1;k<input.length;k++){
                    if(input[j]+input[k]==target)
                        result++;
                    else if(input[j]+input[k]>target)
                        break;
                }
            System.out.println(result);
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
