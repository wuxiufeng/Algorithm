package 剑指Offer;
/**
 * @program: EveryDay
 * @ClassName 二维数组中的查找.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-01 12:23
 */
public class 二维数组中的查找 {
    /**
     * @title Find
     * @description 在二维数组中查找特定值
     * @author Mr. jun
     * @param target 查找目标值
     * @param array 查找矩阵
     * @return boolean
     * @throws
     * @updateTime 2019/10/1 9:11
     */
    public boolean Find(int target, int [][] array) {
        if(array[0].length==0)
            return false;
        int rows = array.length,cols = array[0].length;
        for(int i=0;i<rows;i++){
            if(array[i][0]>target)
                return false;
            if(array[i][cols-1]<target)
                continue;
            for(int j=0;i<cols;j++){
                if(array[i][j]>target)
                    break;
                if(array[i][j]==target)
                    return true;
            }
        }
        return false;
    }
}