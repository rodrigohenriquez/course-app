package com.course.app.controller;

import com.course.app.controller.api.StudentApi;
import com.course.app.service.StudentService;
import com.course.app.service.builder.model.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController implements StudentApi {

    @Autowired
    private StudentService studentService;

    @Override
    public ResponseEntity<StudentVO> find(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.find(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StudentVO>> list() {
        return new ResponseEntity<>(studentService.list(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentVO> save(@RequestBody StudentVO studentVO) {
        return new ResponseEntity<>(studentService.save(studentVO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StudentVO> update(@RequestBody StudentVO studentVO) {
        return new ResponseEntity<>(studentService.update(studentVO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentVO> delete(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.delete(id), HttpStatus.NO_CONTENT);
    }
}
