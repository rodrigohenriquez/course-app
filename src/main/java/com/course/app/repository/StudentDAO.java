package com.course.app.repository;

import com.course.app.repository.model.Student;
import java.util.List;

public interface StudentDAO {

    Student save(Student student);
    Student update(Student student);
    Student remove(Student student);
    Student find(Long id);
    List<Student> list();

}
