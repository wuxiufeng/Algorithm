package Algorithm;

public class QS {
    public static void main(String[] args) {
        //Scanner cin = new Scanner(System.in);
        //int[] input = {5,2,3,7,4,9,12,23,8,7,8,9,10};
        int[] input = {5};
        QuickSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

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
}