package com.company;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int Cases = cin.nextInt();
        for (int i = 0; i < Cases; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int lenM = cin.nextInt(),lenN=cin.nextInt();
            Node[] A1 = new Node[lenM];
            //Node[] A2 = new Node[lenN];
            for (int j = 0; j < lenM; j++) {
                A1[j] = new Node(cin.nextInt());
            }
            for (int j = lenN-1; j >=0; j--) {
                //[j] = new Node(cin.nextInt());
                map.put(cin.nextInt(),j);
            }
            for (int j = 0; j < lenM; j++) {
                if(map.containsKey(A1[j].getVal()))
                    A1[j].setWeight(-5000-map.get(A1[j].getVal()));
            }
            Arrays.sort(A1, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    // TODO Auto-generated method stub
                    if (o1.getWeight() > o2.getWeight())
                        return 1;
                    if (o1.getWeight() < o2.getWeight())
                        return -1;
                    return 0;
                }
            });
            System.out.print(A1[0].getVal());
            for(int j=1;j<lenM;j++)
                System.out.print(" "+A1[j].getVal());
            System.out.println();
        }
    }
}

class Node {
    private int val;
    private int weight;

    public Node(int val) {
        super();
        this.val = val;
        this.weight = val;
    }

    public int getVal() {
        return val;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
