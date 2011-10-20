package com.sheldon.rocking.service.dao;

import java.util.List;

import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;
import com.sheldon.rocking.service.dao.entity.StudentCourse;

public interface StudentCourseDao {

    public StudentCourse store(StudentCourse studentCourse);
    public void delete(Long studentCourseId);
    public StudentCourse findById(Long studentCourseId);
    public List<StudentCourse> findAll();
    public List<Student> findStudentsForCourse(String courseCode);
    public List<Course> findCoursesForStudent(String courseCode);
}
