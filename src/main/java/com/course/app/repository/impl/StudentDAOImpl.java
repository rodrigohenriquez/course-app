package com.course.app.repository.impl;

import com.course.app.repository.StudentDAO;
import com.course.app.repository.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student save(Student student){
        this.entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student update(Student student){
        this.entityManager.merge(student);
        return student;
    }

    @Override
    @Transactional
    public Student remove(Student student){
        this.entityManager.remove(student);
        return student;
    }

    @Override
    @Transactional
    public Student find(Long id){
        TypedQuery<Student> query=this.entityManager.createQuery("select s from Student s where s.id = :id", Student.class);
        query.setParameter("id", id);
        return query.getResultList().size() > 0 ? query.getSingleResult() : new Student();
    }

    @Override
    public List<Student> list(){
        TypedQuery<Student> query=this.entityManager.createQuery("select s from Student s ", Student.class);
        return query.getResultList().size() > 0 ? query.getResultList() : Collections.emptyList();
    }
}
