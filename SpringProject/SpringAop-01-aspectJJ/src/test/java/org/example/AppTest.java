package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.Impl.SomeServiceImpl;
import org.example.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test() {
        String config = "applicationContext.xml";
        ApplicationContext cxl = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) cxl.getBean("someService");
//        SomeServiceImpl someService = (SomeServiceImpl) cxl.getBean("someService");

//        someService.doSome();
        String res = someService.doOther("xiaojiang", 20);
        System.out.println(res);
    }
    @Test
    public void test1() {
        String config = "applicationContext.xml";
        ApplicationContext cxl = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) cxl.getBean("someService");

        Object res = someService.doFirst("xiaojiang");
        System.out.println(res);
    }

    @Test
    public void test2() {
        String config = "applicationContext.xml";
        ApplicationContext cxl = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) cxl.getBean("someService");

        someService.doSecond("xiaojiang");
    }

    @Test
    public void test3() {
        String config = "applicationContext.xml";
        ApplicationContext cxl = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) cxl.getBean("someService");

        someService.doThird("xiaojiang");
    }
}
