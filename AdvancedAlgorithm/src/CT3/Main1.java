package CT3;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main1.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-10-31 09:06
 */
public class Main1 {

    static int findLength(String str, int n) {
        int ans = 0; // Initialize result

        // Consider all possible midpoints one by one
        for (int i = 0; i <= n - 2; i++) {
			/* For current midpoint 'i', keep expanding substring on
		both sides, if sum of both sides becomes equal update
		ans */
            int l = i, r = i + 1;

            /* initialize left and right sum */
            int lsum = 0, rsum = 0;

            /* move on both sides till indexes go out of bounds */
            while (r < n && l >= 0) {
                lsum += str.charAt(l) - '0';
                rsum += str.charAt(r) - '0';
                if (lsum == rsum) {
                    ans = Math.max(ans, r - l + 1);
                }
                l--;
                r++;
            }
        }
        return ans;
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
    // Driver program to test above function
    static public void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            String str = cin.nextLine().trim();
            System.out.printf("%d%n",findLength(str, str.length()));
        }
    }
}
