package org.example.service;

import org.example.domain.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-14
 * Time: 16:43
 */
public interface StudentService  {
    int addStudent(Student student);

    List<Student> queryStudent();
}
