package com.course.app.controller;

import com.course.app.controller.api.CourseApi;
import com.course.app.service.CourseService;
import com.course.app.service.builder.model.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController implements CourseApi {

    @Autowired
    private CourseService courseService;

    @Override
    public ResponseEntity<CourseVO> find(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.find(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseVO>> list() {
        return new ResponseEntity<>(courseService.list(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseVO> save(@RequestBody CourseVO courseVO) {
        return new ResponseEntity<>(courseService.save(courseVO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CourseVO> update(@RequestBody CourseVO courseVO) {
        return new ResponseEntity<>(courseService.update(courseVO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseVO> delete(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.delete(id), HttpStatus.NO_CONTENT);
    }
}
