package com.java8.functions.method;

import java.util.function.Supplier;

/**
 * @author ghl
 * @date 2021/1/8 15:50
 */
public class SupplierTest {
    public static void main(String[] args) {
        System.out.println("生产一个整形数据：" + getInteger(() -> 3));
        System.out.println("生产一个字符串数据：" + getString(() -> "hello"));
    }

    /**
     * 定义一个方法，返回一个整形数据
     *
     * @param function
     * @return
     */
    public static Integer getInteger(Supplier<Integer> function) {
        return function.get();
    }

    /**
     * 返回一个字符串数据
     *
     * @param function
     * @return
     */
    public static String getString(Supplier<String> function) {
        return function.get();
    }
}
