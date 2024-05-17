package com.free.spring.controller;

import com.free.spring.service.BookService;
import com.free.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author free
 * @create 2023-08-26-21:55
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;
    public void buyBook(Integer cusId,Integer bookId){
        bookService.buyBook(cusId,bookId);
    }

    public void checkout(Integer cusId,Integer[] bookIds){
        checkoutService.checkout(cusId,bookIds);
    }
}
