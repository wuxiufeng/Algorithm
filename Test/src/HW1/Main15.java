package HW1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: Test
 * @ClassName Main15.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 11:06
 */
public class Main15 {
    public int LargestRectangleArea(int[] height){
        if (height.length==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i=1, max = height[0];
        stack.push(0);
        while(i< height.length||(i==height.length&& !stack.isEmpty()) ){
            if(i!=height.length && (stack.isEmpty() ||height[i] >= height[stack.peek()])){
                stack.push(i);
                i++;
            }
            else {
                int top  = height[stack.pop()];
                int currMax = !stack.isEmpty()? top *(i - stack.peek()-1): top *i;
                max = Math.max(currMax, max);
            }
        }
        return max;
    }
    public int MaximalRectangle(int[][] rec){
        int[] h = new int[rec[0].length];
        int m = rec.length;
        int n = rec[0].length;
        int max=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0)
                    h[j] =rec[i][j];
                else
                    h[j] = rec[i][j]==0? 0:rec[i-1][j]+1;
            }
            max = Math.max(max, LargestRectangleArea(h));
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = cin.nextInt();
        int[][] input = {{}};
        int row,col;
        for(int i=0;i<caseNum;i++){
            row = cin.nextInt();
            col = cin.nextInt();
            input = new int[row][col];
            for(int j=0;j<row;j++){
                for(int k=0;k<col;k++)
                    input[j][k] = cin.nextInt();
            }
        }
        Main15 rSolution = new Main15();
        int max = rSolution.MaximalRectangle(input);
        System.out.println(max);
    }
}