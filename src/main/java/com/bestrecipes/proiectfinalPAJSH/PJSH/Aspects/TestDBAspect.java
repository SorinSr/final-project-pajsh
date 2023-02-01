package com.bestrecipes.proiectfinalPAJSH.PJSH.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class TestDBAspect {

    private Logger logger = Logger.getLogger(TestDBAspect.class.getName());

    @Around("execution(public com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food testDBConnection())")
    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();

        logger.info("Starting DB initialization and tests - AOP");

        Object result = thisJoinPoint.proceed();

        logger.info("DB initialized successfully - AOP ++++++++++ ");
        return result;
    }

    @Around("execution(public * getAll*(..))")
    public Object logGetAll(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();

        logger.info("### Getter method called : " + methodName + "- AOP");

        return thisJoinPoint.proceed();
    }
}
