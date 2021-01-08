package com.java8.functions.method;

import java.util.function.Function;

/**
 * @author ghl
 * @date 2021/1/8 15:53
 */
public class FunctionTest {
    public static void main(String[] args) {
        Integer integer = convert("123", s -> Integer.parseInt(s));
        System.out.println(integer);
    }

    public static Integer convert(String s, Function<String, Integer> function) {
        return function.apply(s);
    }
}
