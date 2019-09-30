package com.company;

//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int[] input = { 4,3,2,1 };
        System.out.print("begin:");
        for(int i=0;i<input.length;i++)
            System.out.print(input[i]);
        System.out.println();
        Solution so = new Solution();
        System.out.println("InverseNum:"+so.InversePairs(input));
    }
}