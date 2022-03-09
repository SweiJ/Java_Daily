package org.example;

import static org.junit.Assert.assertTrue;

import com.sun.org.apache.bcel.internal.util.ClassPath;
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
        Student mystudent = (Student) cxl.getBean("mystudent");
        String name = mystudent.getName();
        int age = mystudent.getAge();
        System.out.println(name + " " + age);
    }
}
