package 剑指Offer;

/**
 * @program: EveryDay
 * @ClassName 变态跳台阶.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-04 10:15
 */
public class 变态跳台阶 {
    public static void main(String[] args){

    }
    /**
     * @title JumpFloorII
     * @description
     * @author Mr. jun
     * @param target
     * @return int
     * @throws
     * @updateTime 2019/10/4 10:16
     */
    public static int JumpFloorII(int target) {
        return (int) Math.pow(2,target-1);
    }
}
