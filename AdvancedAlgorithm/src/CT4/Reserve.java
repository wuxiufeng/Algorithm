package CT4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Reserve.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-21 11:55
 */
public class Reserve {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while(caseNum-- >0){
            int result = 0;
            int inputLen = Integer.parseInt(cin.nextLine().trim());
            int[] inputArr = StringarrToIntarr(cin.nextLine().trim());
            Arrays.sort(inputArr);
            for(int i=inputLen-1;i>=0;i--){
                result+=inputArr[i];
                for(int j=i;j>=0;j--){
                    if(inputArr[j]==inputArr[i])
                        continue;
                    else if(inputArr[j]==inputArr[i]-1){
                        inputArr[j] = inputArr[i];
                        i--;
                        break;
                    }
                    else if(inputArr[j]<inputArr[i]-1)
                        break;
                }
            }
            System.out.printf("%d\n",result);
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
