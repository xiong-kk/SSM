package com.free.spring.controller;

import com.free.spring.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * @author free
 * @create 2023-06-09-10:09
 */
@Controller
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
