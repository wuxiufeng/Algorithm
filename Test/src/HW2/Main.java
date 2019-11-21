package HW2;

/**
 * @program: Test
 * @ClassName CT4.LessMoney.java.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-26 11:24
 */
class Node {
    int a;
    int b;
    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("123");
        Integer it = new Integer(2);
        Node no = new Node(8,8);
        Change(sb);
        ChangeNode(no);
        System.out.printf("%s%n%d%n", sb, no.getA());

    }

    public static void Change(StringBuilder s) {
        s.append("45645456");
        //s = new StringBuilder("45645456");
    }

    public static void ChangeNode(Node n) {
        //n.a = 9;
        n.setA(99);
    }
}
