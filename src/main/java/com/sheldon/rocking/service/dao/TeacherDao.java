package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dao.entity.Teacher;

public interface TeacherDao {

    public Teacher store(Teacher teacher);
    public void delete(String teacherCode);
    public Teacher find(String teacherCode);
    public List<Teacher> findAll();
}
