package org.example;

import static org.junit.Assert.assertTrue;

import org.example.Dao.StudentDao;
import org.example.domain.Student;
import org.example.service.Impl.StudentServiceImpl;
import org.example.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
    public void fun() {
        String config = "applicationContext.xml";
        ApplicationContext cxl = new ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) cxl.getBean("studentDao");

        Student student = new Student();
        student.setName("zj");
        student.setAge(22);
        studentDao.insertStudent(student);
    }
    @Test
    public void fun1() {
        String config = "applicationContext.xml";
        ApplicationContext cxl = new ClassPathXmlApplicationContext(config);

        StudentService studentService = (StudentService) cxl.getBean("studentService");
        List<Student> students = studentService.queryStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
