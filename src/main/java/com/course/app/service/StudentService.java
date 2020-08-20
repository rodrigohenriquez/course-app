package com.course.app.service;

import com.course.app.service.builder.model.StudentVO;

import java.util.List;

public interface StudentService {

    StudentVO find(Long id);
    List<StudentVO> list();
    StudentVO save(StudentVO studentVO);
    StudentVO update(StudentVO studentVO);
    StudentVO delete(Long id);

}
