package com.bestrecipes.proiectfinalPAJSH.PJSH.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class TestDBAspect {

    private Logger logger = Logger.getLogger(TestDBAspect.class.getName());

    @Pointcut("execution(Food com.bestrecipes.proiectfinalPAJSH.PJSH.Controller.MainController testDBConnection())")
    public void testDB() {}
    @Around("testDB()   ")
    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();

        logger.info("Starting DB initialization and tests - AOP");

        Object result = thisJoinPoint.proceed();

        logger.info("DB initialized successfully - AOP");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return result;
    }

}
