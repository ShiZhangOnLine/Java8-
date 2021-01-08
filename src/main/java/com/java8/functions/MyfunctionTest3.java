package com.java8.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ghl
 * @date 2021/1/8 15:48
 */
public class MyfunctionTest3 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("asfe");
        stringList.add("fsd");
        stringList.add("etrtw");
        stringList.add("csa");
        System.out.println("排序前：" + stringList);
        System.out.println("=======================");

        Collections.sort(stringList, comparator());
        System.out.println("排序后：" + stringList);
    }

    public static Comparator<String> comparator() {
        // 方式1 匿名内部类的方式实现
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

        // 方式2 使用lambda表达式
        return (a, b) -> a.length() - b.length();
    }
}
