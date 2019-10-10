package CT1;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main01.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 10:34
 */
public class Main01
{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        int[] input;
        for(int i=0;i<caseNum;i++){
            cin.nextLine();
            input = StringarrToIntarr(cin.nextLine());
            System.out.println((new MeSo()).GetInvNum(input));
        }
    }
    /**
     * @title StringarrToIntarr
     * @description
     * @author Mr. jun
     * @param string
     * @return int[]
     * @throws
     * @updateTime 2019/10/10 9:20
     */
    public static int[] StringarrToIntarr(String string){
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for(int j=0;j<inputS.length;j++){
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}
class MeSo
{
    /**
     * @title GetInvNum
     * @description
     * @author Mr. jun
     * @param args
     * @return int
     * @throws
     * @updateTime 2019/10/1 9:46
     */
    public int GetInvNum(int[] args) {
        if (args == null || args.length < 2) {
            return 0;
        }
        return MergeSort(args,0,args.length-1);
    }
    /**
     * @title MergeSort
     * @description
     * @author Mr. jun
     * @param arr
     * @param low
     * @param high
     * @return int
     * @throws
     * @updateTime 2019/10/1 9:46
     */
    public int MergeSort(int[] arr,int low,int high){
        if(low == high)
            return 0;
        int mid = ((high - low) >> 1) + low;
        return (MergeSort(arr,low,mid) + MergeSort(arr,mid+1,high) + Merge(arr, low, mid, high))%1000000007;
    }
    /**
     * @title Merge
     * @description
     * @author Mr. jun
     * @param arr
     * @param low
     * @param mid
     * @param high
     * @return int
     * @throws
     * @updateTime 2019/10/1 9:46
     */
    public int Merge(int[] arr, int low, int mid, int high){
        int count = 0;
        int index1 = low,index2 = mid + 1;
        int[] temp = new int[high - low + 1];
        int curIndex = 0;
        while(index1<=mid&&index2<=high){
            if(arr[index1]<=arr[index2]){
                temp[curIndex++] = arr[index1++];
            }
            else{
                temp[curIndex++] = arr[index2++];
                count += ((mid - index1) + 1)%1000000007;
                count%=1000000007;
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
        return count;
    }
}