package com.java0829.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 告诉spring，这个类是一个切面类
 */
@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    // 1. 本类引用
    // 2. 其他的切面引用
    @Pointcut("execution(public int com.java0829.aop.MathCalculator.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint joinpoint){
        Object[] args = joinpoint.getArgs();
        System.out.println(joinpoint.getSignature().getName() + "运行。。。@Before参数列表是：{" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinpoint){
        System.out.println(joinpoint.getSignature().getName() + "除法结束@After");
    }
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinpoint, Object result){
        System.out.println(joinpoint.getSignature().getName() +"除法正常返回。。。@AfterReturning运行结果是：{"+result+"}");
    }

    // joinpoint 一定要出现在参数表的第一位
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinpoint, Exception exception){
        System.out.println(joinpoint.getSignature().getName() +"除法异常。。。@AfterThrowing异常是：{"+exception.getMessage()+"}");
    }
}
