class Solution {
    public int InversePairs(int [] array) {
        return (new MeSo()).GetInvNum(array);
    }
}
class MeSo
{
    public int GetInvNum(int[] args) {
        if (args == null || args.length < 2) {
            return 0;
        }
        return MergeSort(args,0,args.length-1);
    }
    public int MergeSort(int[] arr,int low,int high){
        if(low == high)
            return 0;
        int mid = ((high - low) >> 1) + low;
        return (MergeSort(arr,low,mid) + MergeSort(arr,mid+1,high) + Merge(arr, low, mid, high))%1000000007;
    }
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
                count += ((mid - index1) + 1);
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
