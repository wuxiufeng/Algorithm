package Algorithm;

import java.util.*;
public class MS
{
    public static int Count = 0;
    public static void main(String[] args) {
        //Scanner cin = new Scanner(System.in);
        //int[] input = {5,2,3,7,4,9,12,23,8,7,8,9,10};
        int[] input = randomCommon(-900,900,20);
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
        MergeSort(input,0,input.length-1);
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
    }
    public static void MergeSort(int[] arr,int low,int high){
        int mid = (high + low)/2;
        if(mid>low)
            MergeSort(arr,low,mid);
        if(high>mid+1)
            MergeSort(arr,mid+1,high);
        Merge(arr, low, mid, high);
    }
    public static void Merge(int[] arr, int low, int mid, int high){
        int index1 = low,index2 = mid + 1;
        int[] temp = new int[high - low + 1];
        int curIndex = 0;
        while(index1<=mid&&index2<=high){
            if(arr[index1]<=arr[index2]){
                temp[curIndex++] = arr[index1++];
            }
            else{
                temp[curIndex++] = arr[index2++];
                Count += ((mid - index1) + 1)%1000000007;
            }
        }
        while (index1<=mid){
            temp[curIndex++] = arr[index1++];
        }
        while (index2<=high){
            temp[curIndex++] = arr[index2++];
        }
        for(int i=0; i<temp.length; i++){
            arr[low+i] = temp[i];
        }
    }
    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
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