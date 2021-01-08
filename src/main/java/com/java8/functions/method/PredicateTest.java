package com.java8.functions.method;

import java.util.function.Predicate;

/**
 * @author ghl
 * @date 2021/1/8 15:52
 */
public class PredicateTest {
    public static void main(String[] args) {
        boolean hello = checkString("hello", str -> str.length() > 6);
        System.out.println(hello);
    }

    public static boolean checkString(String s, Predicate<String> function) {
        return function.test(s);
    }
}
