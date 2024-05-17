package com.free.spring.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sound.midi.SoundbankResource;

/**
 * @author free
 * @create 2023-08-26-17:17
 */
@Component
/*@Aspect
@Order(1)*/
public class ValidateAspect {

   /* @Pointcut("execution(* com.free.spring.proxy.CalculatorImpl.*(..))")
    public void pointCut(){}*/

    //@Before("pointCut()")
    public void before(){
        System.out.println("ValidateAspect-->前置通知");
    }

}
