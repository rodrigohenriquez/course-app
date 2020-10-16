package com.course.app.controller.api;

import com.course.app.service.builder.model.StudentVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public interface StudentApi {

    @GetMapping("/{id}")
    ResponseEntity<StudentVO> find(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<List<StudentVO>> list();

    @PostMapping
    ResponseEntity<StudentVO> save(@RequestBody StudentVO studentVO);

    @PutMapping
    ResponseEntity<StudentVO> update(@RequestBody StudentVO studentVO);

    @DeleteMapping
    ResponseEntity<StudentVO> delete(@PathVariable("id") Long id);
}
