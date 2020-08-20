package com.course.app.service.impl;

import com.course.app.repository.StudentDAO;
import com.course.app.repository.model.Student;
import com.course.app.service.StudentService;
import com.course.app.service.builder.StudentVOBuilder;
import com.course.app.service.builder.VOBuilderFactory;
import com.course.app.service.builder.model.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public StudentVO find(Long id){
        if (id == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        Student student = studentDAO.find(id);
        if (student.getId() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return VOBuilderFactory.getStudentVOBuilder(student).build();
    }

    @Override
    public List<StudentVO> list(){
        return studentDAO.list().stream().map(VOBuilderFactory::getStudentVOBuilder)
                .map(StudentVOBuilder::build).collect(Collectors.toList());
    }

    @Override
    public StudentVO save(StudentVO studentVO) {
        if (studentVO == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        return VOBuilderFactory.getStudentVOBuilder(
                studentDAO.save(VOBuilderFactory.getStudentVOBuilder(studentVO).toStudent())
        ).build();
    }

    @Override
    public StudentVO update(StudentVO studentVO) {
        if (studentVO == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        return VOBuilderFactory.getStudentVOBuilder(
                studentDAO.update(VOBuilderFactory.getStudentVOBuilder(studentVO).toStudent())
        ).build();
    }

    @Override
    public StudentVO delete(Long id) {
        if (id == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        return VOBuilderFactory.getStudentVOBuilder(
                studentDAO.remove(studentDAO.find(id))
        ).build();
    }
}
