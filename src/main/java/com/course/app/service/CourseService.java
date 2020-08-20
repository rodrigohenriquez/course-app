package com.course.app.service;

import com.course.app.service.builder.model.CourseVO;

import java.util.List;

public interface CourseService {

    public CourseVO find(Long id);
    public List<CourseVO> list();
    public CourseVO save(CourseVO courseVO);
    public CourseVO update(CourseVO courseVO);
    public CourseVO delete(Long id);

}
