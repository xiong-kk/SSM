package com.free.spring.proxy;

import org.springframework.stereotype.Component;

/**
 * @author free
 * @create 2023-08-25-16:54
 */
@Component
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        int result=i+j;
        System.out.println("方法内部，result: "+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result=i-j;
        System.out.println("方法内部，result: "+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result=i*j;
        System.out.println("方法内部，result: "+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result=i/j;
        System.out.println("方法内部，result: "+result);
        return result;
    }
}
