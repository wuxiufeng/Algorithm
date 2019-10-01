package 基础算法原理;
/**
 * @program: EveryDay
 * @ClassName QS.java
 * @description: 快速排序算法
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-01 09:37
 */
public class QS {
    public static void main(String[] args){
        int[] input = randomCommon(-900,900,20);
        QuickSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
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
            }
            while (lo < hi && arr[lo] <= slice) {
                lo++;
            }
            if (lo < hi) {
                int temp = arr[hi];
                arr[hi] = arr[lo];
                arr[lo] = temp;
                hi--;
            }
        }
        if (lo > low + 1)
            QuickSort(arr, low, lo - 1);
        if (lo < high - 1)
            QuickSort(arr, lo + 1, high);

    }
    /**
     * @title randomCommon
     * @description
     * @author Mr. jun
     * @param min
     * @param max
     * @param n
     * @return int[]
     * @throws
     * @updateTime 2019/10/1 9:39
     */
    public static int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }
}