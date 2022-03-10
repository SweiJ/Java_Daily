package org.example;

import static org.junit.Assert.assertTrue;

import org.example.swei02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test() {
        String config = "applicationContext.xml";
        ApplicationContext cxl = new ClassPathXmlApplicationContext(config);
        Student mystudent = (Student) cxl.getBean("mystudent");

        System.out.println(mystudent);
    }
}
