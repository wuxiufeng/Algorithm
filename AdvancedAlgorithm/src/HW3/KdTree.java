package HW3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName L.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-20 19:44
 */
class DataNode {
    double Distance;
    String Loc;

    public DataNode(double distance, String loc) {
        Distance = distance;
        Loc = loc;
    }
}

public class KdTree {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while (caseNum-- > 0) {
            String[] input1 = cin.nextLine().trim().split(",");
            double[] locationOfIndex = StringarrToDoublearr(cin.nextLine().trim());
            int K = Integer.parseInt(cin.nextLine().trim());
            DataNode[] nodeList = new DataNode[input1.length];
            for (int i = 0; i < input1.length; i++) {
                nodeList[i] = new DataNode(Math.pow(Double.parseDouble(input1[i].split(" ")[0]) - locationOfIndex[0], 2) + Math.pow(Double.parseDouble(input1[i].split(" ")[1]) - locationOfIndex[1], 2), input1[i]);
            }
            Arrays.sort(nodeList, (o1, o2) -> (int) (o1.Distance - o2.Distance));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                double x = Double.parseDouble(nodeList[i].Loc.split(" ")[0]);
                double y = Double.parseDouble(nodeList[i].Loc.split(" ")[1]);
                if (x == (int) x)
                    sb.append((int) x);
                else
                    sb.append(x);
                sb.append(" ");
                if (y == (int) y)
                    sb.append((int) y);
                else
                    sb.append(y);
                sb.append(",");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }

    public static double[] StringarrToDoublearr(String str) {
        String[] inputS = str.split(" ");
        double[] output = new double[inputS.length];
        for (int i = 0; i < inputS.length; i++) {
            output[i] = Double.parseDouble(inputS[i]);
        }
        return output;
    }
}
