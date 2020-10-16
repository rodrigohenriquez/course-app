package com.course.app.service;

import com.course.app.service.builder.model.CourseVO;

import java.util.List;

public interface CourseService {

    CourseVO find(Long id);
    List<CourseVO> list();
    CourseVO save(CourseVO courseVO);
    CourseVO update(CourseVO courseVO);
    CourseVO delete(Long id);

}
