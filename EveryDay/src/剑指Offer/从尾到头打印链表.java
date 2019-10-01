package 剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @program: EveryDay
 * @ClassName 从尾到头打印链表.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-01 12:26
 */
public class 从尾到头打印链表 {
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
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}