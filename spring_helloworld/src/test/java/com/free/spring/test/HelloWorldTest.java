package com.free.spring.test;


import com.free.spring.controller.UserController;
import com.free.spring.dao.UserDao;
import com.free.spring.pojo.Clazz;
import com.free.spring.pojo.HelloWorld;
import com.free.spring.pojo.Persion;
import com.free.spring.pojo.Student;
import com.free.spring.proxy.Calculator;
import com.free.spring.proxy.CalculatorImpl;
import com.free.spring.proxy.CalculatorStaticProxy;
import com.free.spring.proxy.ProxyFactory;
import com.free.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author free
 * @create 2023-06-05-15:59
 */
public class HelloWorldTest {
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();
        Persion persion=ioc.getBean("studentThree",Student.class);
        System.out.println(persion);
    }

    @Test
    public void testDI(){
        //获取IOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        Clazz clazz=ioc.getBean("clazzOne",Clazz.class);
        System.out.println(clazz);
    }


    @Test
    public void testAutowire(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController2 = ioc.getBean("userController2", UserController.class);
        userController2.saveUser();
    }

    @Test
    public void testIOCByAnnotation(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }

    @Test
    public void testProxy(){
       /* CalculatorStaticProxy proxy=new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);*/

        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(1,1);
    }

    @Test
    public void testAop(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(4,1);
    }
}
