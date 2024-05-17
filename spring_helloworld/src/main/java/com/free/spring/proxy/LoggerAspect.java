package com.free.spring.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author free
 * @create 2023-08-26-10:04
 * 在切面中，需要通过指定的注解将方法标识为通知方法
 * @before在目标对象方法执行之前执行
 * @After：后置通知，在finally中执行的
 * @AfterReturning;返回通知，在目标方法返回之后执行
 * @AfterThrowing:异常通知，在目标方法执行出现异常时执行
 *
 *
 * 切入点表达式：设置在标识通知的注解的value属性中
 * execution(* com.free.spring.proxy.CalculatorImpl.*(..))
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示类中任意的方法
 * ..表示任意的参数列表
 * 类的地方也可以写*，表示包下的任意类
 *
 * 获取连接点的信息
 * 在通知方法的参数位置，设置JionPoint类型的参数，就可以获取连接点所对应方法的信息
 *
 * 重用切入点表达式
 * @Pointcut声明一个公共的切入点表达式
 *
 *
 *
 */
@Component
//将当前组件标识为一个切面
//@Aspect
public class LoggerAspect {
    /*@Pointcut("execution(* com.free.spring.proxy.CalculatorImpl.*(..))")
    public void pointCut(){}*/


    //@Before("execution(* com.free.spring.proxy.CalculatorImpl.*(..))")
    //@Before("pointCut()")
    public void beforeAdvice(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("loggerAspect,方法："+signature.getName()+",参数："+ Arrays.toString(args));
    }

    //@After("pointCut()")
    public void afterAdvice(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("loggerAspect,方法："+signature.getName()+",执行完毕");

    }

    //returning属性设置接收通知方法的某个参数指定为接收目标对象方法的返回值
    //@AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint,Object result){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("loggerAspect,方法："+signature.getName()+",结果:"+result);
    }

    //throwing属性设置通知方法的某个参数指定为接收目标对象方法出现的异常的参数
    //@AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint,Exception e){

        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("loggerAspect,方法："+signature.getName()+",异常:"+e);

    }

    //环绕通知的方法一定要与目标对象方法的返回值一致
    //@Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object result=null;
        try {
            System.out.println("环绕通知-前置通知");
            //表示目标方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-异常通知");

        }finally {
            System.out.println("环绕通知-后置通知");
        }
        return result;
    }
}
