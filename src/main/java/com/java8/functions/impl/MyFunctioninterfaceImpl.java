package com.java8.functions.impl;

import com.java8.functions.MyFunctioninterface;

/**
 * @author ghl
 * @date 2021/1/8 15:45
 */
public class MyFunctioninterfaceImpl implements MyFunctioninterface {
    @Override
    public void myMethod() {
        System.out.println("子类实现父类接口方式创建对象");
    }
}
