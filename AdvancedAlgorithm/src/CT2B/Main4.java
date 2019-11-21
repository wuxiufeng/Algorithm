package CT2B;// Java implementation of the approach

import java.util.Scanner;

public class Main4 {
    // Function to return the maximum
    // number of people that can be killed
    static long maxPeople(long p) {
        long tmp = 0, count = 0;

        // Loop will break when the ith person
        // cannot be killed
        for (long i = 1; i * i <= p; i++) {
            tmp = tmp + (i * i);
            if (tmp <= p)
                count++;
            else
                break;
        }
        return count;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = cin.nextInt();
        for (int curi = 0; curi < caseNum; curi++) {
            System.out.println(maxPeople(cin.nextLong()));
        }
    }
}