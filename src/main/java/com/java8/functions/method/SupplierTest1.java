package com.java8.functions.method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

/**
 * @author ghl
 * @date 2021/1/8 15:50
 */
public class SupplierTest1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};


        // 第一版 使用lambda表达式
        int max1 = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        });

        System.out.println("max1 value: " + max1);

        // 第二版：使用流计算的方式升级
        int max2 = getMax(() -> Arrays.stream(arr).boxed().max((x, y) -> x.compareTo(y)).get());
        System.out.println("max2 value: " + max2);

        // 第三版：继续升级，使用方法引用作为参数传递
        int max3 = getMax(() -> Arrays.stream(arr).boxed().max(Comparator.naturalOrder()).get());
        System.out.println("max3 value: " + max3);
    }

    /**
     * 定义获取最大值的方法
     *
     * @param function
     * @return
     */
    public static int getMax(Supplier<Integer> function) {
        return function.get();
    }
}
