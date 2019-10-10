package 剑指Offer;

/**
 * @program: EveryDay
 * @ClassName 旋转数组的最小数字.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-04 11:03
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args){

    }
    /**
     * @title minNumberInRotateArray
     * @description 
     * @author Mr. jun
     * @param array
     * @return int
     * @throws
     * @updateTime 2019/10/4 19:02
     */
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        for(int i=1;i<array.length;i++)
            if(array[i]<array[i-1])
                return array[i];
        return array[0];
    }
}
