package HW3;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while (caseNum > 0) {
            String[] input = cin.nextLine().trim().split(",");
            Set<String> all = new HashSet<String>();
            Set<String> out = new HashSet<String>();
            Set<String> in = new HashSet<S>()
            --caseNum;
        }
    }
    public static char[] StringToChaarr(String string) {
        String[] inputS = string.split(" ");
        char[] output = new char[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = inputS[j].charAt(0);
        }
        return output;
    }
}
