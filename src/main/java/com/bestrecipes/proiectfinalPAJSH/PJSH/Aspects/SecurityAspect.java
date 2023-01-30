package com.bestrecipes.proiectfinalPAJSH.PJSH.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(3)
public class SecurityAspect {

    private Logger logger = Logger.getLogger(TestDBAspect.class.getName());


    @Pointcut("execution(* com.bestrecipes.proiectfinalPAJSH.PJSH.Model*.get*(..))")
    public void modelGetMethod() {}

    @Pointcut("execution(* com.bestrecipes.proiectfinalPAJSH.PJSH.Model*.set*(..))")
    public void modelSetMethod() {}


    @Before("modelGetMethod()")
    public Object logGet(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        logger.info("Aspect logging::: getter " + methodName);

        return thisJoinPoint.proceed();
    }

    @Around("modelSetMethod()")
    public Object logSet(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        logger.info("Aspect logging::: setter: " + methodName + " with arguments: " + Arrays.toString(methodArgs));

        return thisJoinPoint.proceed();
    }

}
