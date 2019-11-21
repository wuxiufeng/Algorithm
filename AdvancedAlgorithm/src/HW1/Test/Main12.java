package HW1.Test;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main12.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 09:41
 */
import java.util.Stack;

public class Main12 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNums = cin.nextInt();
        for(int i=0;i<caseNums;i++)
            System.out.println(hanoiProblem(cin.nextInt(), "left", "mid", "right"));
    }

    public enum Action{
        No,LToM,MToL,MToR,RToM          //描述四个动作：左到中，中到左，中到右，右到中
    }

    public static int hanoiProblem(int num,String left,String mid,String right) {
        Stack<Integer> ls = new Stack<Integer>();
        Stack<Integer> ms = new Stack<Integer>();
        Stack<Integer> rs = new Stack<Integer>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for(int i = num;i>0;i--) {
            ls.push(i);                //左侧栈模拟放着盘子，大的在下，小的在上
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rs.size() != num+1) {    //右侧栈如果存放的数量没有达到num+1时，说明没有全部移动过去，则执行循环
            step += fStackTotStack(record, Action.MToL, Action.LToM, ls, ms, left, right);
            step += fStackTotStack(record, Action.LToM, Action.MToL, ms, ls, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, ms, rs, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rs, ms, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record,Action preNoAct,
                                     Action nowAct,Stack<Integer> fStack,Stack<Integer> tStack,
                                     String from,String to) {
        if(record[0]!=preNoAct && fStack.peek()<tStack.peek()) {
            tStack.push(fStack.pop());
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}