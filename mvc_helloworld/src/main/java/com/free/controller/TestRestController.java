package com.free.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author free
 * @create 2023-09-03-10:17
 *
 *
 * 浏览器目前只能发送get和post请求
 * 若要发送put和delete请求，需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
 * 配置了过滤器之后，发送的请求要满足两个条件，才能将请求方式转换为put和delete
 * 1.当前请求必须为post
 * 2.当前请求必须传输请求参数_method,_method的值才是最终的请求方式
 */
@Controller
public class TestRestController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息");
        return "success2";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息-->/user/"+id+"-->get");
        return "success2";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息");
        return "success2";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息");
        return "success2";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户"+id+"的信息");
        return "success2";
    }





}
