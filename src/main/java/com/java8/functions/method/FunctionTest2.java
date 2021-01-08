package com.java8.functions.method;

import java.util.function.Function;

/**
 * @author ghl
 * @date 2021/1/8 15:53
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        Integer integer1 = convert("32", s -> Integer.parseInt(s), i -> i + 100);
        System.out.println(integer1);
    }

    public static Integer convert(String s, Function<String, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(s);
    }
}
