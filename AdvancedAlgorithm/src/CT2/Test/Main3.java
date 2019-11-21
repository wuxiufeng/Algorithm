package CT2.Test;// Java Program for painter's partition problem
import java.util.*;

public class Main3 {
    // return the maximum element from the array
    static int getMax(int arr[], int n)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // return the sum of the elements in the array
    static int getSum(int arr[], int n)
    {
        int total = 0;
        for (int i = 0; i < n; i++)
            total += arr[i];
        return total;
    }

    // find minimum required painters for given maxlen
    // which is the maximum length a painter can paint
    static int numberOfPainters(int arr[], int n, int maxLen)
    {
        int total = 0, numPainters = 1;

        for (int i = 0; i < n; i++) {
            total += arr[i];

            if (total > maxLen) {

                // for next count
                total = arr[i];
                numPainters++;
            }
        }

        return numPainters;
    }

    static int partition(int arr[], int n, int k)
    {
        int lo = getMax(arr, n);
        int hi = getSum(arr, n);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(arr, n, mid);

            // find better optimum in lower half
            // here mid is included because we
            // may not get anything better
            if (requiredPainters <= k)
                hi = mid;

                // find better optimum in upper half
                // here mid is excluded because it gives
                // required Painters > k, which is invalid
            else
                lo = mid + 1;
        }

        // required
        return lo;
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

    // Driver code
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            int[] input1 = StringarrToIntarr(cin.nextLine().trim());
            int[] input2 = StringarrToIntarr(cin.nextLine().trim());
            System.out.println(partition(input2, input1[1], input1[0]));
        }
    }
}