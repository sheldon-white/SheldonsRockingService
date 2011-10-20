package com.sheldon.rocking.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;



@Repository("courseDao")
public class JpaCourseDao implements CourseDao {

	static final String findSQL = "SELECT c FROM Course c where c.courseCode = ?";

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Course store(Course course) {
        Course managedCourse = entityManager.merge(course);
        return managedCourse;
    }

    @Transactional
    public void delete(String courseCode) {
        Query query = entityManager.createQuery(findSQL);
        query.setParameter(1, courseCode);
        Course course = (Course) query.getSingleResult();
        entityManager.remove(course);
    }

    @Transactional(readOnly = true)
    public Course find(String courseCode) {
        Query query = entityManager.createQuery(findSQL);
        query.setParameter(1, courseCode);
        Course course = (Course) query.getSingleResult();

    	return course;
    }

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        Query query = entityManager.createQuery("from Course");
        return query.getResultList();
    }
}
