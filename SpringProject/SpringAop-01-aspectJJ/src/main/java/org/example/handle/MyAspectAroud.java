package org.example.handle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 15:07
 */
@Aspect
public class MyAspectAroud {
    /**
     * 前置通知方法的定义
     * 1. 作用域 public
     * 2. 必须有返回值 建议使用Object
     * 3. 方法名称自定义
     * 4. 方法有参数 ProceedingJoinPoint
     *
     * @Around() 环绕通知
     *  属性: value 切入点表达式
     *  位置: 在方法定义的上面
     *
     *  返回值: Object 表示调用目标方法希望得到执行结果 返回切面函数的返回值
     *  参数: ProceedingJoinPoint 相当于反射中的Method  调用了业务代码
     *      作用: 执行目标方法的, 等于Method.invoke()
     */
    @Around("execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAroud(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("MyAspectAroud.myAroud");

        // 执行了业务代码中的方法
        Object proceed = pj.proceed();
        // 返回值是业务代码的返回值
        System.out.println(proceed);

        return "helloAroud";
    }
}
