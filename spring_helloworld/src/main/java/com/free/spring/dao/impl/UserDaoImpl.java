package com.free.spring.dao.impl;

import com.free.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author free
 * @create 2023-06-09-10:13
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
