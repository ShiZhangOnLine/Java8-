package com.java8.functions;

import com.java8.functions.impl.MyFunctioninterfaceImpl;

/**
 * @author ghl
 * @date 2021/1/8 15:46
 */
public class FunctionTest {
    public static void main(String[] args) {
        // 第一种方式，使用子类创建对象
        MyFunctioninterface instance1 = new MyFunctioninterfaceImpl();
        instance1.myMethod();

        // 第二种方式，使用匿名内部类方式创建对象
        MyFunctioninterface instance2 = new MyFunctioninterface() {
            @Override
            public void myMethod() {
                System.out.println("匿名内部类方式创建对象");
            }
        };
        instance2.myMethod();

        // 第三种方式，使用lambda表达式方式创建对象
        MyFunctioninterface instance3 = () -> System.out.println("lambda表达式方式创建对象");
        instance3.myMethod();

    }
}
