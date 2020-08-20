package com.course.app.repository.impl;

import com.course.app.repository.CourseDAO;
import com.course.app.repository.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public Course save(Course course){
        this.entityManager.persist(course);
        return course;
    }

    @Override
    @Transactional
    public Course update(Course course){
        this.entityManager.merge(course);
        return course;
    }

    @Override
    @Transactional
    public Course remove(Course course){
        this.entityManager.remove(course);
        return course;
    }

    @Override
    @Transactional
    public Course find(Long id){
        TypedQuery<Course> query=this.entityManager.createQuery("select c from Course c where c.id = :id", Course.class);
        query.setParameter("id", id);
        return query.getResultList().size() > 0 ? query.getSingleResult() : new Course();
    }

    @Override
    public List<Course> list(){
        TypedQuery<Course> query=this.entityManager.createQuery("select c from Course c ", Course.class);
        return query.getResultList().size() > 0 ? query.getResultList() : Collections.emptyList();
    }
}
