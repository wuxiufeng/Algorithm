package HW1;

/**
 * @program: Test
 * @ClassName CT1.Main3.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-16 20:58
 */
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main.java.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 09:10
 */
public class Main3 {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int[] input;
        int windSize;
        int result;
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for(int i=0;i<caseNum;i++){
            input = StringarrToIntarr(cin.nextLine());
            windSize = Integer.parseInt(cin.nextLine().trim());
            result = 0;
            for(int k=0;k<=input.length-windSize;k++){
                int currMax = input[k];
                for(int l=1;l<windSize;l++)
                    if(input[k+l]>currMax)
                        currMax = input[k+l];
                result+=currMax;
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
