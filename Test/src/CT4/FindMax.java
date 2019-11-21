package CT4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName FindMax.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-21 09:00
 */
public class FindMax {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while(caseNum>0){
            int result = 0;
            boolean flag = true;
            int inputLen = Integer.parseInt(cin.nextLine().trim());
            int[] inputArr = StringToIntarr(cin.nextLine().trim());
            Arrays.sort(inputArr);
            for(int i=0;i<inputLen;i++){
                if(inputArr[i]<0&&flag){
//                    System.out.printf("%d\n",inputArr[i]);
                    flag = false;
                    continue;
                }
                result+=inputArr[i];
            }
            System.out.printf("%d\n",result);
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
