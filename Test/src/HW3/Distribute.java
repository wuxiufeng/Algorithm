package HW3;

import java.util.*;

/**
 * @program: Test
 * @ClassName Distribute.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-18 21:12
 */
public class Distribute {
    public static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while (caseNum > 0) {
            MIN = Integer.MAX_VALUE;
            int n = Integer.parseInt(cin.nextLine().trim());
            int[][] cost = new int[n][n];
            String[] input = cin.nextLine().trim().split(",");
            for (int i = 0; i < input.length; i++) {
                int[] tocost = StringToIntarr(input[i]);
                cost[tocost[0]-1][tocost[1]-1] = tocost[2];
            }
            int[] pemutationArr = new int[n];
            for (int i = 0; i < n; i++)
                pemutationArr[i] = i;
            Map<Integer, List<Integer[]>> map = new HashMap<Integer, List<Integer[]>>();
            Pemutation(pemutationArr, 0, n - 1, cost, map);
            List<Integer[]> listResult = map.get(MIN);
            String[] stringResult = new String[listResult.size()];
            for(int i=0;i<listResult.size();i++) {
                Integer[] it = listResult.get(i);
                stringResult[i] = new String(String.valueOf(it[0]));
                for (int j = 1; j < it.length; j++) {
                    stringResult[i] += (" "+String.valueOf(it[j]));
                }
            }
            Arrays.sort(stringResult, (o1, o2) -> 0);
            System.out.printf("%s",stringResult[stringResult.length-1]);
            for(int i=stringResult.length-2;i>=0;i--){
                System.out.printf(",%s",stringResult[i]);
            }
            System.out.printf("\n");
            --caseNum;
        }
    }

    public static void Pemutation(int[] arr, int from, int to, int[][] cost, Map<Integer, List<Integer[]>> map) {
        if (from == to) {
            int result = 0;
            Integer[] currPrmutation = new Integer[arr.length];
            for (int i = 0; i <= to; i++) {
//                System.out.printf("%d ",arr[i]+1);
                currPrmutation[i] = arr[i]+1;
                result += cost[i][arr[i]];
            }
//            System.out.printf("\n%d\n",result);
            if (result <= MIN) {
//            if(true){
                MIN = result;
                if (!map.containsKey(result)) {
                    map.put(result, new LinkedList<Integer[]>());
                    map.get(result).add(currPrmutation);
                }
                else
                    map.get(result).add(currPrmutation);
            }
        } else {
            for (int i = from; i < arr.length; i++) {
                int temp = arr[i];
                arr[i] = arr[from];
                arr[from] = temp;
                Pemutation(arr, from + 1, to, cost, map);
                temp = arr[i];
                arr[i] = arr[from];
                arr[from] = temp;
            }
        }
    }

    public static int[] StringToIntarr(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}
