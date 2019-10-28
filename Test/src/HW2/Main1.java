package HW2;

import java.util.*;

/**
 * @program: Test
 * @ClassName Main1.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-28 15:28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int casei = 0; casei < caseNum; casei++) {
            String input1 = cin.nextLine().trim();
            String input2 = cin.nextLine().trim();
            int[][] dp = new int[input1.length() + 1][input2.length() + 1];
            Set<String> resultset = new HashSet<String>();
            DP(input1, input2, dp);
            GetAllResult(new StringBuffer(), input1.length(), input2.length(), resultset, dp, input1, input2);
            List<String> resultlist = new LinkedList<String>(resultset);
            Collections.sort(resultlist);
            for (String s : resultlist) {
                System.out.printf("%s%n", s);
            }
        }
    }

    public static void DP(String s1, String s2, int[][] dpArr) {
        for (int i = 0; i < dpArr.length; i++)
            dpArr[i][0] = 0;
        for (int i = 0; i < dpArr[0].length; i++)
            dpArr[0][i] = 0;
        for (int i = 1; i < dpArr.length; i++)
            for (int j = 1; j < dpArr[0].length; j++)
                dpArr[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? (dpArr[i - 1][j - 1] + 1) : Math.max(dpArr[i][j - 1], dpArr[i - 1][j]);
    }

    public static void GetAllResult(StringBuffer currStr, int currI, int currJ, Set<String> resultlist, int[][] dpArr, String s1, String s2) {
        if (currI <= 0 || currJ <= 0)
            resultlist.add(currStr.reverse().toString());
        else {
            if (s1.charAt(currI - 1) == s2.charAt(currJ - 1)) {
                //currStr = s1.charAt(currI-1)+currStr;
                GetAllResult(currStr.append(s1.charAt(currI - 1)), currI - 1, currJ - 1, resultlist, dpArr, s1, s2);
            } else if (dpArr[currI][currJ - 1] < dpArr[currI - 1][currJ]) {
                GetAllResult(currStr, currI - 1, currJ, resultlist, dpArr, s1, s2);
            } else if (dpArr[currI][currJ - 1] > dpArr[currI - 1][currJ]) {
                GetAllResult(currStr, currI, currJ - 1, resultlist, dpArr, s1, s2);
            } else {
                GetAllResult(new StringBuffer(currStr), currI - 1, currJ, resultlist, dpArr, s1, s2);
                GetAllResult(new StringBuffer(currStr), currI, currJ - 1, resultlist, dpArr, s1, s2);
            }
        }
    }
}
