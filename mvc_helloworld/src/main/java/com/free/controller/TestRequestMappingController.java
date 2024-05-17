package com.free.controller;

import com.free.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @author free
 * @create 2023-08-27-18:07
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(value = "/hello",method= RequestMethod.POST)
    public String hello(){
        return "success";
    }


    @RequestMapping("/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user) {
        System.out.println(user);
        return "success";
    }


    @RequestMapping("/mav")
    public ModelAndView testMav(){

        /*
        * Model:向请求域中共享数据
        * View:设置逻辑视图实现页面跳转
        * */
        ModelAndView mav=new ModelAndView();
        mav.addObject("testRequestScope","hello,ModelAndView");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";
    }

    @RequestMapping("/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello,application");
        return "success";
    }
}
