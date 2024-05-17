package com.free.spring.test;

import com.free.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author free
 * @create 2023-06-08-10:40
 */
public class LifeCycleTest {
    @Test
    public void test(){
        //ConfigurableApplicationContext是ApplicationContext的子接口，扩展了刷新和关闭ioc容器的方法
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student=ioc.getBean(Student.class);
        System.out.println(student);
        ioc.close();
    }
}
