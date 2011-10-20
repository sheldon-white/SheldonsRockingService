package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dao.entity.Student;

public interface StudentDao {

    public Student store(Student student);
    public void delete(String studentCode);
    public Student find(String studentCode);
    public List<Student> findAll();
}
