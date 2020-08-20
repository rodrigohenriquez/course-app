package com.course.app.service.impl;

import com.course.app.repository.CourseDAO;
import com.course.app.repository.model.Course;
import com.course.app.service.CourseService;
import com.course.app.service.builder.CourseVOBuilder;
import com.course.app.service.builder.VOBuilderFactory;
import com.course.app.service.builder.model.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public CourseVO find(Long id){
        if (id == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        Course course = courseDAO.find(id);
        if (course.getId() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return VOBuilderFactory.getCourseVOBuilder(course).build();
    }

    @Override
    public List<CourseVO> list(){
        return courseDAO.list().stream().map(VOBuilderFactory::getCourseVOBuilder)
                .map(CourseVOBuilder::build).collect(Collectors.toList());
    }

    @Override
    public CourseVO save(CourseVO courseVO) {
        if (courseVO == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        return VOBuilderFactory.getCourseVOBuilder(
                courseDAO.save(VOBuilderFactory.getCourseVOBuilder(courseVO).toCourse())
        ).build();
    }

    @Override
    public CourseVO update(CourseVO courseVO) {
        if (courseVO == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        return VOBuilderFactory.getCourseVOBuilder(
                courseDAO.update(VOBuilderFactory.getCourseVOBuilder(courseVO).toCourse())
        ).build();
    }

    @Override
    public CourseVO delete(Long id) {
        if (id == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        return VOBuilderFactory.getCourseVOBuilder(
                courseDAO.remove(courseDAO.find(id))
        ).build();
    }

}
