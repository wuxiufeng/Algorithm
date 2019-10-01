/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    /**
     * @title printListFromTailToHead
     * @description
     * @author Mr. jun
     * @param listNode
     * @return java.util.ArrayList<java.lang.Integer>
     * @throws
     * @updateTime 2019/10/1 12:06
     */
    ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(listNode!=null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);
        return result;
    }
}