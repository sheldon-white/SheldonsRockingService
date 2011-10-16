package com.sheldon.rocking.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ExampleAspect {
	
    @Around("execution(* com.sheldon.rocking.service.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aspect Around started...");
        Object retVal = pjp.proceed();
        System.out.println("aspect Around ended...");
        return retVal;
    }
}