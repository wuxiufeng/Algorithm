package 剑指Offer;

import java.util.Arrays;

/**
 * @program: EveryDay
 * @ClassName 重建二叉树.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-01 15:21
 */
public class 重建二叉树 {
    public static void main(String[] args) {
        int[] p = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] i = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(p, i);
        System.out.print(12313);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) throws IllegalArgumentException{
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
    public static int FindIndexOf(int val, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}