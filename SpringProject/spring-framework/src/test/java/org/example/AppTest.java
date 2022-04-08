package org.example;

import static org.junit.Assert.assertTrue;

import org.example.controller.UserController;
import org.example.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.charset.StandardCharsets;

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
        String application = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(application);
        User user = new User("xiaojiang", 21);
        UserController uController = (UserController) applicationContext.getBean("uController");
        System.out.println(uController.insert(user));
    }
}
