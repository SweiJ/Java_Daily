package org.example.Dao;

import org.example.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-14
 * Time: 16:19
 */
public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudents();
}
