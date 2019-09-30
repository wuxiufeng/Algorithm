package com.company;

public class 二维数组中的查找 {
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