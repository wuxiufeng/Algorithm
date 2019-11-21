package CT1;

//import java.util.Scanner;

import CT1.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int[] input = { 4,3,2,1 };
        System.out.print("begin:");
        for(int i=0;i<input.length;i++)
            System.out.print(input[i]);
        System.out.println();
        int[] ne = Arrays.copyOf(input,input.length);
        input[0] = 9090;
        for(int i=0;i<ne.length;i++)
            System.out.print(ne[i]);
        System.out.println();
        for(int i=0;i<input.length;i++)
            System.out.print(input[i]);
        Solution so = new Solution();
        System.out.println("InverseNum:"+so.InversePairs(input));
    }
}