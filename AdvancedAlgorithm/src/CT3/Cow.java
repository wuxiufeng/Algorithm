package CT3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Cow.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-10-31 10:29
 */
public class Cow {
    static Map<Long, Long> resultMap = new HashMap<Long, Long>();

    public static long Fib(long n) {
        if (resultMap.containsKey(n))
            return resultMap.get(n);
        if (n % 2 == 0)
            resultMap.put(n, (Fib(n >> 1) * Fib(n >> 1) + Fib((n >> 1) - 1) * Fib((n >> 1) - 1)) % 1000000007);
        else
            resultMap.put(n, (Fib((n - 1) >> 1) * (Fib((n - 1) >> 1) + (Fib((n - 3) >> 1) << 1))) % 1000000007);
        return resultMap.get(n);
    }

    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        resultMap.put((long) 0, (long) 1);
        resultMap.put((long) 1, (long) 1);
        resultMap.put((long) 2, (long) 2);
        int t = ab.nextInt();
        while (t-- > 0) {
            System.out.println(ab.nextLong());
        }
    }
}
