package 剑指Offer;

/**
 * @program: EveryDay
 * @ClassName 斐波那契数列.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-04 00:02
 */
public class 斐波那契数列 {
    public static void main(String[] args){
        System.out.println(Fibonacci(32));
    }
    /**
     * @title Fibonacci
     * @description 
     * @author Mr. jun
     * @param n
     * @return int
     * @throws
     * @updateTime 2019/10/4 0:09
     */
    public static int Fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
