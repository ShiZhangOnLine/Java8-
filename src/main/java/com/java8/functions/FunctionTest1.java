package com.java8.functions;

/**
 * @author ghl
 * @date 2021/1/8 15:47
 */
public class FunctionTest1 {
    public static void main(String[] args) {
        System.out.println("2 + 3 = " + add(2, 3));
        System.out.println("2 - 3 = " + sub(2, 3));
        System.out.println("2 * 3 = " + mut(2, 3));
        System.out.println("2 / 3 = " + div(2, 3));
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int sub(int x, int y) {
        return x - y;
    }

    public static int mut(int x, int y) {
        return x * y;
    }

    public static int div(int x, int y) {
        return x / y;
    }
}
