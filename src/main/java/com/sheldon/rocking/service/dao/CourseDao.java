package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dao.entity.Course;

public interface CourseDao {

    public Course store(Course course);
    public void delete(String courseCode);
    public Course find(String courseCode);
    public List<Course> findAll();
}
