import java.util.Arrays;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) throws IllegalArgumentException{
        if (pre.length == 0)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        if (pre.length == 1)
            return node;
        int indexOfNode = FindIndexOf(node.val, in);
        if(indexOfNode==-1)
            throw new IllegalArgumentException("输入参数异常");
        node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, indexOfNode + 1), Arrays.copyOfRange(in, 0, indexOfNode));
        node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, indexOfNode + 1, pre.length), Arrays.copyOfRange(in, indexOfNode + 1, in.length));
        return node;
    }
    /**
     * @param val
     * @param arr
     * @return int
     * @throws
     * @title FindIndexOf
     * @description 查找特定值在数组中的下标，若不存在则返回-1.
     * @author Mr. jun
     * @updateTime 2019/10/1 15:57
     */
    public int FindIndexOf(int val, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}