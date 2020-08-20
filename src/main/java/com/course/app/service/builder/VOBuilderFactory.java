package com.course.app.service.builder;

import com.course.app.repository.model.Course;
import com.course.app.repository.model.Student;
import com.course.app.service.builder.model.CourseVO;
import com.course.app.service.builder.model.StudentVO;

public class VOBuilderFactory {

    private VOBuilderFactory() {
    }

    public static CourseVOBuilder getCourseVOBuilder(Course course) {
        return new CourseVOBuilder().fromCourse(course);
    }

    public static CourseVOBuilder getCourseVOBuilder(CourseVO courseVO) {
        return new CourseVOBuilder().fromCourseVO(courseVO);
    }

    public static StudentVOBuilder getStudentVOBuilder(Student student){
        return new StudentVOBuilder().fromStudent(student);
    }

    public static StudentVOBuilder getStudentVOBuilder(StudentVO studentVO){
        return new StudentVOBuilder().fromStudentVO(studentVO);
    }


}
