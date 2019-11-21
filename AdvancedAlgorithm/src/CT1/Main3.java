package CT1;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        for (int i = 0; i < num; i++) {
            int len = cin.nextInt();
            int[] input = new int[len];
            for (int j = 0; j < len; j++) {
                input[j] = cin.nextInt();
            }
            QS q = new QS();
            System.out.println(q.getNum(input));
        }
    }
}

class QS {
    private int count = 0;

    public int getNum(int[] input) {
        sort(input, 0, input.length - 1);
        return count;
    }

    public void sort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        int k = arr[low];
        while (l < h) {
            while (l < h && arr[h] >= k) {
                h--;// h=6
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
                count++;
            }
            while (l < h && arr[l] <= k) {
                l++;
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
                count++;
            }
        }
        if (l > low)
            sort(arr, low, l - 1);
        if (h < high)
            sort(arr, l + 1, high);
    }
}