package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dao.entity.Course;

public interface CourseDao {

    public Course store(Course course);
    public void delete(Long courseId);
    public Course findById(Long courseId);
    public List<Course> findAll();
}
