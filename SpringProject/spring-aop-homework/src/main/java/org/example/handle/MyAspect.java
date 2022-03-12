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

    @Around("execution(* *..NumberServiceImpl.addNum(..))")
    public Object myAroud( ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Boolean isFalse = true;
        for (Object arg : args) {
            if(arg == null || (Integer) arg <= 0) {
                isFalse = false;
                break;
            }
        }
        Object proceed;
        if(isFalse) {
            proceed = pjp.proceed();
        }  else {
            return -1;
        }
        return proceed;
    }
}
