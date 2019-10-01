package 基础算法原理;
/**
 * @program: EveryDay
 * @ClassName Ms.java
 * @description: 归并排序算法，以逆序数为应用
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-01 09:43
 */
public class MS {
    public static void main(String[] args) {
        System.out.println((new MeSo()).GetInvNum(randomCommon(-100000, 100000, 100000)));
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
     * @updateTime 2019/10/1 9:45
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
        return (MergeSort(arr,low,mid)%1000000007 + MergeSort(arr,mid+1,high)%1000000007 + Merge(arr, low, mid, high))%1000000007;
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