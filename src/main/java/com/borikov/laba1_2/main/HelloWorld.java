package com.borikov.laba1_2.main;

public class HelloWorld {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            if (i % 2 != 0) {
                System.out.println("Hello world #" + i);
            }
        }
        for (int i = 1; i <= 20; i++) {
            if (i >= 10 && i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
