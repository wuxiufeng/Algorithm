package CT1;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main02.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 10:57
 */
public class Main02 {
    public static int Count = 0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        for (int i = 0; i < num; i++) {
            int len = cin.nextInt();
            int[] input = new int[len];
            for (int j = 0; j < len; j++) {
                input[j] = cin.nextInt();
            }
            QuickSort(input,0,input.length-1);
            System.out.println(Count);
            Count = 0;
        }
    }
    /**
     * @title QuickSort
     * @description
     * @author Mr. jun
     * @param arr
     * @param low
     * @param high
     * @return void
     * @throws
     * @updateTime 2019/10/1 9:40
     */
    public static void QuickSort(int[] arr, int low, int high) {
        int lo = low;
        int hi = high;
        int slice = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] >= slice) {
                hi--;
            }
            if (lo < hi) {
                int temp = arr[hi];
                arr[hi] = arr[lo];
                arr[lo] = temp;
                lo++;
                Count++;
            }
            while (lo < hi && arr[lo] <= slice) {
                lo++;
            }
            if (lo < hi) {
                int temp = arr[hi];
                arr[hi] = arr[lo];
                arr[lo] = temp;
                hi--;
                Count++;
            }
        }
        if (lo > low + 1)
            QuickSort(arr, low, lo - 1);
        if (lo < high - 1)
            QuickSort(arr, lo + 1, high);

    }
}