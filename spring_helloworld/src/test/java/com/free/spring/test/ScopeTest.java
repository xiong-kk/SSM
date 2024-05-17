package com.free.spring.test;

import com.free.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author free
 * @create 2023-06-08-10:27
 */
public class ScopeTest {
    @Test
    public void testScope(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student1=ioc.getBean(Student.class);
        Student student2=ioc.getBean(Student.class);
        System.out.println(student1==student2);
    }
}
