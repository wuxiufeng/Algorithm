package CT2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            int[] input1 = StringarrToIntarr(cin.nextLine().trim());
            int[] input2 = StringarrToIntarr(cin.nextLine().trim());
            System.out.println(partition(input2, input1[1], input1[0]));
        }
    }

    static int getMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    static int getSum(int[] arr, int n) {
        int total = 0;
        for (int i = 0; i < n; i++)
            total += arr[i];
        return total;
    }

    static int numberOfPainters(int[] arr, int n, int maxLen) {
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

    static int partition(int[] arr, int n, int k) {
        int lo = getMax(arr, n);
        int hi = getSum(arr, n);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(arr, n, mid);
            if (requiredPainters <= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
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
}