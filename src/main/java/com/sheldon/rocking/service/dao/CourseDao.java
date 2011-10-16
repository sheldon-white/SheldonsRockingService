package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dataobject.Course;

public interface CourseDao {

    public void store(Course course);
    public void delete(Long courseId);
    public Course findById(Long courseId);
    public List<Course> findAll();
}
