package 剑指Offer;

/**
 * @program: EveryDay
 * @ClassName 矩形覆盖.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-04 19:01
 */
public class 矩形覆盖 {
    public static void main(String[] args){
        
    }
    /**
     * @title RectCover
     * @description 
     * @author Mr. jun
     * @param target
     * @return int
     * @throws
     * @updateTime 2019/10/4 19:04
     */
    public static int RectCover(int target) {
        if(target==0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        return RectCover(target-1)+RectCover(target-2);
    }
}
