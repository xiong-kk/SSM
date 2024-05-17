package com.free.spring.dao;

/**
 * @author free
 * @create 2023-08-26-21:57
 */
public interface BookDao {
    /*
    * 根据图书的id查询图书的价格
    * */
    Integer getPriceByBookId(Integer bookId);

    /*
    * 更新图书的库存
    * */
    void updateStock(Integer bookId);

    /*
    * 更新用户的余额
    * */
    void updateBalance(Integer cusId,Integer price);
}
