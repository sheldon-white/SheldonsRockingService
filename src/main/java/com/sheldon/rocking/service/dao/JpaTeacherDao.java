package com.sheldon.rocking.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sheldon.rocking.service.dao.entity.Teacher;



@Repository("TeacherDao")
public class JpaTeacherDao implements TeacherDao {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Teacher store(Teacher Teacher) {
        Teacher managedTeacher = entityManager.merge(Teacher);
        return managedTeacher;
    }

    @Transactional
    public void delete(Long TeacherId) {
        Teacher Teacher = entityManager.find(Teacher.class, TeacherId);
        entityManager.remove(Teacher);
    }

    @Transactional(readOnly = true)
    public Teacher findById(Long TeacherId) {
        return entityManager.find(Teacher.class, TeacherId);
    }

    @Transactional(readOnly = true)
    public List<Teacher> findAll() {
        Query query = entityManager.createQuery("from Teacher");
        List<Teacher> teachers = query.getResultList();
        
        return teachers;
    }
}
