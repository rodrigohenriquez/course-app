package com.course.app.service.builder;

import com.course.app.repository.model.Course;
import com.course.app.service.builder.model.CourseVO;

public class CourseVOBuilder {

    private Course course;
    private CourseVO courseVO;

    public CourseVOBuilder fromCourse(Course course) {
        this.course = course;
        return this;
    }

    public CourseVOBuilder fromCourseVO(CourseVO courseVO) {
        this.courseVO = courseVO;
        return this;
    }

    public CourseVO build(){
        if (course == null) return null;

        CourseVO courseVO = new CourseVO();
        courseVO.setId(course.getId());
        courseVO.setName(course.getName());
        courseVO.setCode(course.getCode());

        return courseVO;
    }

    public Course toCourse(){
        if (courseVO == null) return null;

        Course course = new Course();
        course.setId(courseVO.getId());
        course.setName(courseVO.getName());
        course.setCode(courseVO.getCode());
        return course;
    }
}
