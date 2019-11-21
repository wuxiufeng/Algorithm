import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName TrueFindMax.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-21 09:46
 */
class Main {

    public static double maximumSum(double[] arr) {
        int N=arr.length;
        double result=Integer.MIN_VALUE,sum_with_delete=arr[0], sum_without_delete=arr[0];
        if(N==1){
            return arr[0];
        }

        for(int i=1;i<N;i++){
            double sum_without_delete_temp=Math.max(sum_without_delete+arr[i], arr[i]);
            sum_with_delete=Math.max(sum_without_delete, sum_with_delete+arr[i]);
            sum_without_delete=sum_without_delete_temp;

            result=Math.max(result, Math.max(sum_with_delete, sum_without_delete));
        }

        return result;
    }
    // Driver code
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while(caseNum-- >0){
//            int result = 0;
            boolean flag = true;
            int inputLen = Integer.parseInt(cin.nextLine().trim());
            double[] inputArr = StringToDoublearr(cin.nextLine().trim());
//            Arrays.sort(inputArr);
//            for(int i=0;i<inputLen;i++){
//                if(inputArr[i]<0&&flag){
////                    System.out.printf("%d\n",inputArr[i]);
//                    flag = false;
//                    continue;
//                }
//                result+=inputArr[i];
//            }
            System.out.printf("%.0f\n",maximumSum(inputArr));
        }
    }

    public static double[] StringToDoublearr(String string) {
        String[] inputS = string.split(" ");
        double[] output = new double[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Double.parseDouble(inputS[j]);
        }
        return output;
    }
}