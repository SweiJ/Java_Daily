package org.example;

import static org.junit.Assert.assertTrue;

import org.example.dao.UserDao;
import org.example.domain.SysUser;
import org.example.service.impl.UserServiceImpl;
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
    public void text() {
        String config = "applicationContext.xml";
        ApplicationContext cxt =  new ClassPathXmlApplicationContext(config);
        SysUser user = (SysUser) cxt.getBean("user");
        UserServiceImpl userServiceImpl = (UserServiceImpl) cxt.getBean("userServiceImpl");

        userServiceImpl.addUser(user);
    }
}
