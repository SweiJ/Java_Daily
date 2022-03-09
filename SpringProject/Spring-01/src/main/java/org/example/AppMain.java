package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-09
 * Time: 10:37
 */
public class AppMain {
    public static void main(String[] args) {
        String config = "beans.xml";

        // 声明的是Spring容器的对象 将配置文件中的class类创建对象   默认调用的是该类的无参构造方法
        // spring 有几个bean就创建几个对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        someService someservice = (someService)ctx.getBean("someservice");
        someservice.doSome();
    }
}
