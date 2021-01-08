package com.java8.functions.method;

import java.util.function.Consumer;

/**
 * @author ghl
 * @date 2021/1/8 15:51
 */
public class ConsumerTest {
    public static void main(String[] args) {
        // 方式1 消费一次字符串
        operatorString("张三", s -> System.out.println("名字是：" + s));
        // 方式2 消费两次字符串
        operatorString("李四", s -> System.out.println("function1 名字是：" + s),
                s1 -> System.out.println("function2 名字是：" + s1));
    }

    /**
     * 定义一个方法，以不同的方式消费字符串两次
     *
     * @param name
     * @param function1
     * @param function2
     */
    public static void operatorString(String name, Consumer<String> function1, Consumer<String> function2) {
        function1.andThen(function2).accept(name);
    }

    /**
     * 定义一个方法，消费一个字符串
     *
     * @param name
     * @param function
     */
    public static void operatorString(String name, Consumer<String> function) {
        function.accept(name);
    }
}
