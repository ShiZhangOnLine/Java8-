package com.java8.functions;

import java.util.function.Supplier;

/**
 * @author ghl
 * @date 2021/1/8 15:47
 */
public class MyfunctionTest2 {
    public static void main(String[] args) {
        int i1 = fun(() -> 2 + 3);
        System.out.println(i1);
        int i2 = fun(() -> 2 - 3);
        System.out.println(i2);
        Supplier<Integer> add = () -> 2 + 3;
        Supplier<Integer> sub = () -> 2 - 3;
        Supplier<Integer> nut = () -> 2 * 3;
        Supplier<Integer> dit = () -> 2 / 3;

        System.out.println("加法："+fun(add));
        System.out.println("减法："+fun(sub));
        System.out.println("乘法："+fun(nut));
        System.out.println("除法："+fun(dit));

        System.out.println("========================");
        System.out.println("加法："+fun(() -> 2 + 3));
        System.out.println("减法："+fun(() -> 2 - 3));
        System.out.println("乘法："+fun(() -> 2 * 3));
        System.out.println("除法："+fun(() -> 2 / 3));

    }


    public static int fun(Supplier<Integer> function) {
        return function.get();
    }
}
