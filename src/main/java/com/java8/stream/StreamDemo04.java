package com.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ghl
 * @date 2021/1/8 15:10
 */
public class StreamDemo04 {
    public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("linqingxia");
        list.add("zhangmanyu");
        list.add("wangzuxian");
        list.add("liuyan");
        list.add("zhangmin");
        list.add("zhangwuji");

        //1：按照字母顺序把数据在控制台输出
         list.stream().sorted().forEach(System.out::println);

        System.out.println("=========================");

        //2：按照字符串长度把数据在控制台输出
        list.stream().sorted((s1,s2) -> {
            int num = s1.length()-s2.length();
            int num2 = num==0?s1.compareTo(s2):num;
            return num2;
        }).forEach(System.out::println);
    }
}
