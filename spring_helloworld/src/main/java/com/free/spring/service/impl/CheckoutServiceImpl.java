package com.free.spring.service.impl;

import com.free.spring.service.BookService;
import com.free.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author free
 * @create 2023-08-26-23:07
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    @Override
    //@Transactional
    public void checkout(Integer cusId, Integer[] bookIds) {
        for (Integer bookId:bookIds) {
            bookService.buyBook(cusId,bookId);
        }
    }
}
