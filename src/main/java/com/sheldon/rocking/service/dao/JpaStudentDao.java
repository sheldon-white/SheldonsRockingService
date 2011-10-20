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



@Repository("StudentDao")
public class JpaStudentDao implements StudentDao {

	static final String findSQL = "SELECT s FROM Student s where s.studentCode = ?";

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
    public void delete(String studentCode) {
        Query query = entityManager.createQuery(findSQL);
        query.setParameter(1, studentCode);
        Student student = (Student) query.getSingleResult();
        entityManager.remove(student);
    }

    @Transactional(readOnly = true)
    public Student find(String studentCode) {
        Query query = entityManager.createQuery(findSQL);
        query.setParameter(1, studentCode);
        Student student = (Student) query.getSingleResult();

    	return student;
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        Query query = entityManager.createQuery("from Student");
        List<Student> students = query.getResultList();
        
        return students;
    }
}
