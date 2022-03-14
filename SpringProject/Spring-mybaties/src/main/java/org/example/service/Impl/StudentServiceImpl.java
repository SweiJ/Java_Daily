package org.example.service.Impl;

import org.example.Dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-14
 * Time: 16:44
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
