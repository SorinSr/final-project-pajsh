package com.bestrecipes.proiectfinalPAJSH.PJSH.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(TestDBAspect.class.getName());

    @Pointcut("execution(* com.bestrecipes.proiectfinalPAJSH.PJSH.Model*.*(..))")
    public void modelMethod() {}

    @Pointcut("execution(* com.bestrecipes.proiectfinalPAJSH.PJSH.Controller*.*(..))")
    public void controllerMethod() {}

    @Pointcut("execution(* com.bestrecipes.proiectfinalPAJSH.PJSH.Repository*.*(..))")
    public void repositoryMethod() {}


    @Around("modelMethod() && controllerMethod() && repositoryMethod()")
    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        logger.info("Aspect logging::: method started: " + methodName + " with arguments: " + Arrays.toString(methodArgs));

        Object result = thisJoinPoint.proceed();

        logger.info("Aspect logging::: method finished: " + methodName);

        return result;
    }

}
