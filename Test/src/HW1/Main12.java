package HW1;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName Main12.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-10 09:41
 */
public class Main12 {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int caseNum = cin.nextInt();
        for(int i=0;i<caseNum;i++){
            System.out.println(Math.pow(2,cin.nextInt()));
        }
    }
}
