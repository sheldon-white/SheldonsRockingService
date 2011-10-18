package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dao.entity.Teacher;

public interface TeacherDao {

    public Teacher store(Teacher teacher);
    public void delete(Long teacherId);
    public Teacher findById(Long teacherId);
    public List<Teacher> findAll();
}
