package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;

public interface StudentDao {

    public Student store(Student student);
    public void delete(Long studentId);
    public Student findById(Long studentId);
    public List<Student> findAll();
}
