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
import com.sheldon.rocking.service.dao.entity.StudentCourse;



@Repository("StudentCourseDao")
public class JpaStudentCourseDao implements StudentCourseDao {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public StudentCourse store(StudentCourse studentCourse) {
    	StudentCourse managedStudentCourse = entityManager.merge(studentCourse);
        return managedStudentCourse;
    }

    @Transactional
    public void delete(Long studentCourseId) {
    	StudentCourse studentCourse = entityManager.find(StudentCourse.class, studentCourseId);
        entityManager.remove(studentCourse);
    }

    @Transactional(readOnly = true)
    public StudentCourse findById(Long studentCourseId) {
        return entityManager.find(StudentCourse.class, studentCourseId);
    }

    @Transactional(readOnly = true)
    public List<StudentCourse> findAll() {
        Query query = entityManager.createQuery("from StudentCourse");
        return query.getResultList();
    }
    
    @Transactional(readOnly = true)
    public List<Student> findStudentsForCourse(Long courseId) {
        Query query = entityManager.createQuery("SELECT s FROM Student s, StudentCourse sc WHERE sc.student = s and sc.course.id = ?");
        query.setParameter(1, courseId);
        List<Student> results = (List<Student>) query.getResultList();
        
        return results;
    }

    @Transactional(readOnly = true)
    public List<Course> findCoursesForStudent(Long studentId) {
        Query query = entityManager.createQuery("SELECT c FROM Course c, StudentCourse sc WHERE sc.course = c and sc.student.id = ?");
        query.setParameter(1, studentId);
        List<Course> results = (List<Course>) query.getResultList();
        
        return results;
    }

}
