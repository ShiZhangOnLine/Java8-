package com.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ghl
 * @date 2021/1/8 15:16
 */
public class StreamDemo05 {
    public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");
        //需求：将集合中的字符串数据转换为整数之后在控制台输出
        list.stream().map(s -> Integer.parseInt(s));

    }
}
