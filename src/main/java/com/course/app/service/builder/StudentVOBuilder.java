package com.course.app.service.builder;

import com.course.app.repository.model.Student;
import com.course.app.service.builder.model.StudentVO;

public class StudentVOBuilder {

    private Student student;
    private StudentVO studentVO;

    public StudentVOBuilder fromStudent(Student student){
        this.student = student;
        return this;
    }

    public StudentVOBuilder fromStudentVO(StudentVO studentVO){
        this.studentVO = studentVO;
        return this;
    }

    public StudentVO build(){
        if (student == null) return null;
        StudentVO studentVO = new StudentVO();
        studentVO.setId(student.getId());
        studentVO.setRut(student.getRut());
        studentVO.setName(student.getName());
        studentVO.setLastName(student.getLastName());
        studentVO.setAge(student.getAge());
        if (student.getCourse() != null){
            studentVO.setCourse(
                    VOBuilderFactory.getCourseVOBuilder(student.getCourse()).build()
            );
        }
        return studentVO;
    }

    public Student toStudent(){
        if (studentVO == null) return null;

        Student student = new Student();
        student.setId(studentVO.getId());
        student.setRut(studentVO.getRut());
        student.setName(studentVO.getName());
        student.setLastName(studentVO.getLastName());
        student.setAge(studentVO.getAge());
        if (studentVO.getCourse() != null){
            student.setCourse(
                    VOBuilderFactory.getCourseVOBuilder(studentVO.getCourse()).toCourse()
            );
        }
        return student;
    }
}
