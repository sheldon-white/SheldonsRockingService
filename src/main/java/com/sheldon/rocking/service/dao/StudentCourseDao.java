package com.sheldon.rocking.service.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;
import com.sheldon.rocking.service.dao.entity.StudentCourse;

public interface StudentCourseDao {

    public StudentCourse store(StudentCourse studentCourse);
    public void delete(Long studentCourseId);
    public StudentCourse findById(Long studentCourseId);
    public List<StudentCourse> findAll();
    public List<Student> findStudentsForCourse(Long courseId);
    public List<Course> findCoursesForStudent(Long studentId);
}
