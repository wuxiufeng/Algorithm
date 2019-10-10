package HW1;

/**
 * @program: Test
 * @ClassName Main17.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-11 00:08
 */
import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * @author chaplinJ
 *
 */
public class Main17 {

    public int getNum(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int res = 0;

        int i = 0;
        int j = 0;
        Deque<Integer> qmax = new LinkedList<>();
        Deque<Integer> qmin = new LinkedList<>();
        while(i < arr.length){
            while( j < arr.length){

                //维护窗口最大值
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                //维护窗口最小值
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }
            res += j - i;
            if(qmax.peekFirst() == i){
                qmax.poll();
            }
            if(qmin.peekFirst() == i){
                qmin.poll();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        int result = new Main17().getNum(a, 4);
        System.out.println(result);
    }
}