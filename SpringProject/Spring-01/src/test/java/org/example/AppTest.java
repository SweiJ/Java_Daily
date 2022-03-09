package org.example;

import static org.junit.Assert.assertTrue;

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
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void test() {
        String config = "beans.xml";
        ApplicationContext cxt = new ClassPathXmlApplicationContext(config);
        int nums = cxt.getBeanDefinitionCount();
        System.out.println("beans nums==" + nums);
        String[] Names = cxt.getBeanDefinitionNames();
        for (String name : Names) {
            System.out.println("class is == " + name);
        }
        cxt.getBean("someservice");
    }
}
