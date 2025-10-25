package com.free.spring.dao.impl;

import com.free.spring.dao.BookDao;
import com.free.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author free
 * @create 2023-08-26-21:57
 */
@Repository
public class BookDaoImpl implements BookDao {


    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql="select price from t_book where book_id=?";

        return jdbcTemplate.queryForObject(sql,Integer.class,bookId);
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql="update t_book set stock=stock-1 where book_id=?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateBalance(Integer cusId,Integer price) {
        String sql="update t_cus set balance=balance-? where cus_id=?";
        jdbcTemplate.update(sql,price,cusId);
    }
}
