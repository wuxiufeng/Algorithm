package CT2B;// Java program for optimal allocation of pages

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main2.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-17 19:12
 */
public class Main3 {
    // Utility method to check if current minimum value
    // is feasible or not.
    static boolean isPossible(int[] arr, int n, int m, int curr_min) {
        int studentsRequired = 1;
        int curr_sum = 0;

        // iterate over all books
        for (int i = 0; i < n; i++) {
            // check if current number of pages are greater
            // than curr_min that means we will get the result
            // after mid no. of pages
            if (arr[i] > curr_min)
                return false;

            // count how many students are required
            // to distribute curr_min pages
            if (curr_sum + arr[i] > curr_min) {
                // increment student count
                studentsRequired++;

                // update curr_sum
                curr_sum = arr[i];

                // if students required becomes greater
                // than given no. of students,return false
                if (studentsRequired > m)
                    return false;
            }

            // else update curr_sum
            else
                curr_sum += arr[i];
        }
        return true;
    }

    // method to find minimum pages
    static int findPages(int[] arr, int n, int m) {
        long sum = 0;

        // return -1 if no. of books is less than
        // no. of students
        if (n < m)
            return -1;

        // Count total number of pages
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // initialize start as 0 pages and end as
        // total pages
        int start = 0, end = (int) sum;
        int result = Integer.MAX_VALUE;

        // traverse until start <= end
        while (start <= end) {
            // check if it is possible to distribute
            // books by using mid is current minimum
            int mid = (start + end) / 2;
            if (isPossible(arr, n, m, mid)) {
                // if yes then find the minimum distribution
                result = Math.min(result, mid);

                // as we are finding minimum and books
                // are sorted so reduce end = mid -1
                // that means
                end = mid - 1;
            } else
                // if not possible means pages should be
                // increased so update start = mid + 1
                start = mid + 1;
        }

        // at-last return minimum no. of pages
        return result;
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

    // Driver Method
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            int arrLength = Integer.parseInt(cin.nextLine().trim());
            int[] arr = StringarrToIntarr(cin.nextLine().trim());
            int m = Integer.parseInt(cin.nextLine().trim());
            System.out.println(findPages(arr, arrLength, m));
        }
    }
}
