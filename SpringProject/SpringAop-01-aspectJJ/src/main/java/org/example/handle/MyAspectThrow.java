package org.example.handle;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 15:41
 */
@Aspect
public class MyAspectThrow {

    /**
     * 前置通知方法的定义
     * 1. 作用域 public
     * 2. 返回值 void
     * 3. 方法名称自定义
     * 4. 方法返回值是Exception
     * @param ex
     * @AfterThrowing: 异常通知
     *  属性: value: 切入点表达式
     *      throwing 自定义变量, 表示目标方法抛出的异常
     *              变量名必须和通知方法的新参名一样
     *  位置: 在方法的上面
     *  特点:
     *  1.在目标方法抛出异常后执行的 没有异常不执行
     *  2.能取到目标方法的异常信息
     *  3.不是异常处理程序 可以得到发生异常的通知, 可以发送邮件, 短信通知
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))", throwing = "ex")
    public void myThrow(Exception ex) {
        System.out.println("MyAspectThrow.myThrow" + ex.getMessage());
    }
}
