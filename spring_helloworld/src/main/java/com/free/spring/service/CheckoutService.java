package com.free.spring.service;

/**
 * @author free
 * @create 2023-08-26-23:07
 */
public interface CheckoutService {

    void checkout(Integer cusId, Integer[] bookIds);
}
