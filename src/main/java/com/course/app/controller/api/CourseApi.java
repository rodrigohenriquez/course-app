package com.course.app.controller.api;

import com.course.app.service.builder.model.CourseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public interface CourseApi {

    @GetMapping("/{id}")
    ResponseEntity<CourseVO> find(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<List<CourseVO>> list();

    @PostMapping
    ResponseEntity<CourseVO> save(@RequestBody CourseVO courseVO);

    @PutMapping
    ResponseEntity<CourseVO> update(@RequestBody CourseVO courseVO);

    @DeleteMapping
    ResponseEntity<CourseVO> delete(@PathVariable("id") Long id);

}
