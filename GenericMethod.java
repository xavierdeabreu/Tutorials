package com.company;

public class Main {

    public static void main(String[] args) {
        Integer[] iray = {1,2,3,4,5};
        Character[] cray = {'x', 'a','v','i','e','r'};

        printMe(iray);
        printMe(cray);
    }
    //generic Method
    public static <T> void printMe(T[] x){
        for(T b:x)
            System.out.printf("%s ", b);
        System.out.println();
    }
}
