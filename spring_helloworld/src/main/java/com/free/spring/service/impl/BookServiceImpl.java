package com.free.spring.service.impl;

import com.free.spring.dao.BookDao;
import com.free.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author free
 * @create 2023-08-26-21:56
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyBook(Integer cusId, Integer bookId) {
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //查询图书的价格
        Integer price= bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(cusId,price);

    }
}
