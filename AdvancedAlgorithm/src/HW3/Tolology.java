package HW3;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tolology {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while (caseNum > 0) {
            int result = 1;
            String[] input = cin.nextLine().trim().split(",");
            Set<String> all = new HashSet<String>();
            Set<String> out = new HashSet<String>();
            Set<String> in = new HashSet<String>();

            for (int i = 0; i < input.length; i++) {
                all.add(input[i].split(" ")[0]);
                all.add(input[i].split(" ")[1]);
            }
            while (!all.isEmpty()) {
                in.clear();
                for (int i = 0; i < input.length; i++) {
                    if (!all.contains(input[i].split(" ")[0]))
                        continue;
                    in.add(input[i].split(" ")[1]);
                }
                out.clear();
                out.addAll(all);
                out.removeAll(in);
                result *= (out.size());
                all.removeAll(out);
            }
            System.out.printf("%d\n", result);
//            out = all.removeAll(in);

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
