package com.sheldon.rocking.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sheldon.rocking.service.dao.entity.Student;



@Repository("StudentDao")
public class JpaStudentDao implements StudentDao {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Student store(Student Student) {
        Student managedStudent = entityManager.merge(Student);
        return managedStudent;
    }

    @Transactional
    public void delete(Long StudentId) {
        Student Student = entityManager.find(Student.class, StudentId);
        entityManager.remove(Student);
    }

    @Transactional(readOnly = true)
    public Student findById(Long StudentId) {
        return entityManager.find(Student.class, StudentId);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        Query query = entityManager.createQuery("from Student");
        List<Student> students = query.getResultList();
        
        return students;
    }
}
