package com.java8.functions.method;

import java.util.function.Predicate;

/**
 * @author ghl
 * @date 2021/1/8 15:52
 */
public class PredicateTest2 {
    public static void main(String[] args) {

        boolean world = checkString("world", str1 -> str1.length() > 6, str2 -> str2.length() < 10);
        System.out.println(world);
    }

    public static boolean checkString(String s, Predicate<String> function1, Predicate<String> function2) {
        return function1.or(function2).test(s);
    }
}
