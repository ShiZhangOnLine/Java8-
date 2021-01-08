package com.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ghl
 * @date 2021/1/8 15:06
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        //1：取前3个数据在控制台输出
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("--------");
        //2：跳过3个元素，把剩下的元素在控制台输出
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("--------");
        //3：跳过2个元素，把剩下的元素中前2个在控制台输出
        list.stream().skip(2).limit(2).forEach(System.out::println);
    }
}
