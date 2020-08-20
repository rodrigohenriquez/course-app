package com.course.app.repository;

import com.course.app.repository.model.Course;
import java.util.List;

public interface CourseDAO {

    Course save(Course course);
    Course update(Course course);
    Course remove(Course course);
    Course find(Long id);
    List<Course> list();

}
