package com.java8.functions.method;

import java.util.function.Consumer;

/**
 * @author ghl
 * @date 2021/1/8 15:51
 */
public class ConsumerTest2 {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33"};
        printInfo(strArray,
                str-> System.out.println("姓名："+str.split(",")[0]),
                str2-> System.out.println("年龄："+str2.split(",")[1]));
    }

    public static void printInfo(String[] strings, Consumer<String> function1, Consumer<String> function2) {
        for (String string : strings) {
            function1.andThen(function2).accept(string);
        }
    }
}
