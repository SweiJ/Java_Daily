package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.NumberService;
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

        // 此时已经创建了对象
        NumberService number = (NumberService) cxl.getBean("number");

        Integer integer = number.addNum(0, 200, 110);
        System.out.println(integer);
    } 
}
