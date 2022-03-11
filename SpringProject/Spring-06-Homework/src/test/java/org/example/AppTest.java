package org.example;

import static org.junit.Assert.assertTrue;

import org.example.example.domain.SysUser;
import org.example.example.service.impl.UserServiceImpl;
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
        UserServiceImpl userServiceImpl = (UserServiceImpl) cxl.getBean("userServiceImpl");
        SysUser user = (SysUser) cxl.getBean("user");
//        SysUser sysUser = new SysUser();
//        sysUser.setAge(22);
//        sysUser.setName("xiaojiang");
//        userServiceImpl.addUser(sysUser);
        userServiceImpl.addUser(user);
    }
}
