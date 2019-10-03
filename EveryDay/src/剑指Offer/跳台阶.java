package 剑指Offer;

import java.util.jar.JarEntry;

/**
 * @program: EveryDay
 * @ClassName 跳台阶.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-04 00:09
 */
public class 跳台阶 {
    public static void main(String[] args){
        System.out.println(JumpFloor(3));
    }
    /**
     * @title JumpFloor
     * @description
     * @author Mr. jun
     * @param target
     * @return int
     * @throws
     * @updateTime 2019/10/4 0:10
     */
    public static int JumpFloor(int target) {
        if(target==0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

}
