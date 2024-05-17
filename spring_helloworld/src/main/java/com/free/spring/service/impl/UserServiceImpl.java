package com.free.spring.service.impl;

import com.free.spring.dao.UserDao;
import com.free.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author free
 * @create 2023-06-09-10:11
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
