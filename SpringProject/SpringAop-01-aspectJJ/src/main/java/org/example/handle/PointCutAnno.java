package org.example.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 16:11
 */
@Aspect
public class PointCutAnno {

    // 当多个切面方法对应的目标方法是同一个的时候, 可以使用@PointCut统一管理
    @Before(value = "myPt()")
    public void myBefore(JoinPoint jp) {
        System.out.println("MyAspect.myBefore" + new Date());
    }

    @After(value = "myPt()")
    public void myAfter() {
        System.out.println("MyAspectAfter.myAfter");
    }

    @Pointcut("execution(* *..SomeServiceImpl.doThird(..))")
    public void myPt() {

    }
}
