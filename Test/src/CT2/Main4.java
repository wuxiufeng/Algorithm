package CT2;

/**
 * @program: Test
 * @ClassName Main17.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-11 00:08
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        GetPrime();
        Scanner cin = new Scanner(System.in);
        int caseNum = cin.nextInt();
        for (int curi = 0; curi < caseNum; curi++) {
            long input = cin.nextInt();
            //System.out.println(getNum(input));
        }
    }

    public static List<Integer> GetPrime(){
        boolean[] notPrime = new boolean[(int) Math.pow(10,6)+1];
        int p = 2;
        while(p*p<notPrime.length){
            if(notPrime[p]==false)
                for(int i=p*2;i<notPrime.length;i+=p)
                    notPrime[i] = true;
            p++;
        }
        List<Integer> result = new LinkedList<Integer>();
        for(int i=2;i<notPrime.length;i++)
            if(!notPrime[i])
                result.add(i);
        for(Integer i:result)
            System.out.println(i);

        return result;
    }

    public static long getNum(long[] arr) {
        long result = 1;
        while(arr[1]!=1){
            if(arr[1]%2==1){
                result = result*arr[0];
                result = result%arr[2];
            }
            arr[0] = arr[0]*arr[0];
            arr[0] = arr[0]%arr[2];
            arr[1] = arr[1]/2;
        }
        return (result*arr[0])%arr[2];
    }
}