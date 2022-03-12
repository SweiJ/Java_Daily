package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.NumService;
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

        NumService num = (NumService) cxl.getBean("num");
        Integer integer = num.doAdd(100, 200, 110);
        System.out.println(integer);
    }
}
