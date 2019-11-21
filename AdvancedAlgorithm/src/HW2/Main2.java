package HW2;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main1.cpp
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-26 11:24
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            System.out.println(IsPalindrome(cin.nextLine().trim().split(" ")) ? "true" : "false");
        }
    }

    public static boolean IsPalindrome(String[] strArr) {
        for (int i = 1, j = strArr.length - 1; i <= j; i++, j--)
            if (!strArr[i].equals(strArr[j]))
                return false;
        return true;
    }
}
