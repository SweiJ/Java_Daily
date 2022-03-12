package org.example.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 14:38
 */
@Aspect
public class MyAspectAfterRet {
    /**
     * @AfterReturning: 后置通知
     *  属性: value 切入点表达式
     *        returning 自定义变量 表示目标方法的返回值
     *                  自定义变量名称必须和通知方法的形参一样
     *  特点:
     *  1.在目标方法之后执行
     *  2.能获取目标方法的执行结果
     *  3.不会影响目标方法执行
     *
     *  方法的参数
     *      Object res 表示目标方法的返回值 使用res 接收doOther的调用结果
     *      Object res = doOther()
     *  后置通知执行顺序
     *      Object res = * * ..SomeServiceImpl.doOther(..);
     *      myAfter(res);
     *  如果返回的类型为 String Integer double 等基本类型在方法体内修改值不会影响
     *  如果类型为对象 会影响
     */
    @AfterReturning(value = "execution(* * ..SomeServiceImpl.doOther(..))", returning = "res")
    public void myAfter(Object res) {
        if(res != null) {
            // 不会影响外部结果
            res = "hello";
        }
        System.out.println("后置通知 在目标方法执行之后执行" + res);
    }
}
