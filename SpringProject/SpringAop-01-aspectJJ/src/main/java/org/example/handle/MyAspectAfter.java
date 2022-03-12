package org.example.handle;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 15:58
 */
@Aspect
public class MyAspectAfter {
    /**
     * 1. 作用域 public
     * 2. 返回值 void
     * 3. 方法名称自定义
     * 4. 方法没有参数
     *
     * 特点:
     * 1. 在目标方法之后执行
     * 2. 总是会被执行
     * 3. 一般做程序的收尾工作  内存清理
     *
     * try {
     *     * *..SomeServcieImpl.doThird(..)
     * } finally {
     *     myAfter()
     * }
     */
    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter() {
        System.out.println("MyAspectAfter.myAfter");
    }
}
