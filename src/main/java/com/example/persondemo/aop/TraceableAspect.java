package com.example.persondemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class TraceableAspect {

    /**
     * Log the execution time of the method, and the returned value
     *
     * @param proceedingJoinPoint This is the object that holds the information about the method being called.
     * @return The return value of the method.
     */
    @Around("@annotation(com.example.persondemo.aop.Traceable)")
    public Object logMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        try {
            long start = System.currentTimeMillis();
            Object proceed = proceedingJoinPoint.proceed();
            log.info("AOP - End of method '{}' (duration {} ms). Returned value => {}", proceedingJoinPoint.toShortString(), (System.currentTimeMillis() - start), proceed);
            return proceed;
        } catch (Throwable throwable) {
            log.info("AOP - Error while executing method '{} with cause '{}'", proceedingJoinPoint.toShortString(), throwable);
            throw throwable;
        }
    }
}
