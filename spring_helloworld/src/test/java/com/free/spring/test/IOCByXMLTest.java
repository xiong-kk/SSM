package com.free.spring.test;

import com.free.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author free
 * @create 2023-06-05-16:24
 */
public class IOCByXMLTest {
    /*
        获取bean的三种方式
        1.通过bean的唯一标识id获取
        2.通过bean的类型获取,根据类型获取bean时，要求IOC容器中只有一个匹配的bean。不能没有，也不能多个。
        类型匹配时，可以是接口类型，只要符合instanceof就可以。
        3.根据bean的类型和id获取
     */
    @Test
    public void testIOC(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //Student student1 = (Student) ioc.getBean("student1");
        Student student1 = ioc.getBean("studentOne",Student.class);
        System.out.println(student1);
        Student studentTwo = ioc.getBean("studentTwo", Student.class);
        System.out.println(studentTwo);
    }
}
