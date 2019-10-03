package 剑指Offer;

import java.util.Stack;

/**
 * @program: EveryDay
 * @ClassName 用两个栈实现队列.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-02 08:03
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        while(!stack1.empty())
            stack2.push(stack1.pop());
        int peek = stack2.pop();
        while(!stack2.empty())
            stack1.push(stack2.pop());
        return peek;
    }
}
