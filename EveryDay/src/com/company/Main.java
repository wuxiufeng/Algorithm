package com.company;

public class Main {
    public static void main(String[] args){

    }
    public String replaceSpace(StringBuffer str) {
        String in = str.toString();
        return in.replaceAll(" ","%20");
    }
}
