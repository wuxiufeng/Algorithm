package com.company;

import java.util.*;

public class Variant {
    public static void main(String[] args){
        String[] input = {"eat","ate","tea","deposit","dopiest","posited"};
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for(int i=0;i<input.length;i++){
            String curSign = Sign(input[i]);
            if(map.containsKey(curSign)){
                map.get(curSign).add(input[i]);
            }
            else{
                map.put(curSign,new HashSet<String>(Collections.singleton(input[i])));
            }
        }
        for(String str : map.keySet()){
            System.out.print("签名为"+str+"单词有：");
            for(String subString : map.get(str)){
                System.out.print(subString+" ");
            }
            System.out.println();
        }
    }
    public static String Sign(String in){
        char[] charString = in.toCharArray();
        Arrays.sort(charString);
        return new String(charString);
    }
}
