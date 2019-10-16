package HW1.Test;

/**
 * @program: Test
 * @ClassName Main17.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-11 00:08
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main17 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            System.out.println(getNum(StringarrToIntarr(cin.nextLine()), Integer.parseInt(cin.nextLine().trim())));
        }
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

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;

        int i = 0;
        int j = 0;
        Deque<Integer> qmax = new LinkedList<>();
        Deque<Integer> qmin = new LinkedList<>();
        while (i < arr.length-1) {
            while (j < arr.length) {
                //维护窗口最大值
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                //维护窗口最小值
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            res+=arr.length-j;
            if (qmax.peekFirst() == i) {
                qmax.poll();
            }
            if (qmin.peekFirst() == i) {
                qmin.poll();
            }
            i++;
        }
        return res;
    }
}