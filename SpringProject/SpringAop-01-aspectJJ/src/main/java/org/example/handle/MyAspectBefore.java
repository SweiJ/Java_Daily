package org.example.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: @Aspect: 切面类的注解
 *              位置: 放在某个类的上面
 *              作用: 表示当前类是切面类
 *              切面类: 表示切面功能的类
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 9:10
 */

@Aspect
public class MyAspectBefore {
    /**
     * 前置通知方法的定义
     * 1. 作用域 public
     * 2. 返回值 void
     * 3. 方法名称自定义
     * 4. 方法可以有参数 JoinPoint
     *
     * @Before: 前置通知
     *  属性: value切入点表达式 表示切面的执行位置
     *        在这个方法时, 会同时执行切面的功能
     *  位置: 在方法的上面
     *
     *  特点:
     *      1. 执行期间 在目标方法之前先执行的
     *      2. 不会影响目标方法的执行
     *      3. 不会修改目标方法的执行结果
     */
//    @Before(value = "execution(public void org.example.service.Impl.SomeServiceImpl.doSome())")
//    public void myBefore() {
//        System.out.println("MyAspect.myBefore" + new Date());
//    }

    /*
     * 给方法加上参数 joinPoint 表示正在执行的业务方法
     * 使用要求: 必须是参数的第一个
     * 作用: 获取方法执行的信息, 例如方法名称 方法的参数集合
     */
    @Before(value = "execution(public void org.example.service.Impl.SomeServiceImpl.doSome())")
    public void myBefore(JoinPoint jp) {
        System.out.println("前置通知中, 获取目标方法的定义" + jp.getSignature());
        System.out.println("获取方法名称" + jp.getSignature().getName());
        // 获取方法执行是的参数
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数" + arg);
        }
        System.out.println("MyAspect.myBefore" + new Date());
    }
}
