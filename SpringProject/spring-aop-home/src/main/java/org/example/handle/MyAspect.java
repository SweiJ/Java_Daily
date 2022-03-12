package org.example.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 16:35
 */
@Aspect
public class MyAspect {
    @Around("execution(* *..NumServiceImpl.doAdd(..))")
    public Object myAdd(ProceedingJoinPoint pj) {
        System.out.println("MyAspect.myAdd");
        return 10;
    }
}
