package com.sheldon.rocking.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;
import com.sheldon.rocking.service.dao.entity.Teacher;
import com.sheldon.rocking.service.response.AssignmentResponse;
import com.sheldon.rocking.service.response.CourseResponse;
import com.sheldon.rocking.service.response.CoursesResponse;
import com.sheldon.rocking.service.response.StudentResponse;
import com.sheldon.rocking.service.response.StudentsResponse;
import com.sheldon.rocking.service.response.TeacherResponse;
import com.sheldon.rocking.service.response.TeachersResponse;

@WebService
public interface RockingService {

	@XmlElement(required = true, name = "course_id")
    public Course findCourse(@WebParam(name = "course_id") Long courseId);
    
	@XmlElement(required = true, name = "student_id")
    public Student findStudent(@WebParam(name = "student_id") Long studentId);

	public CourseResponse addCourse(@WebParam(name = "course") Course course);

    public StudentResponse addStudent(@WebParam(name = "student") Student student);
    
    public TeacherResponse addTeacher(@WebParam(name = "teacher") Teacher teacher);
    
    public StudentsResponse findStudentsForCourse(@WebParam(name = "course_id") Long courseId);
    
    public CoursesResponse findCoursesForStudent(@WebParam(name = "student_id") Long studentId);
    
    public AssignmentResponse enrollStudent(@WebParam(name = "student") Student student,
    										@WebParam(name = "course") Course course);

    public AssignmentResponse enrollStudentById(@WebParam(name = "student_id") Long studentId,
    											@WebParam(name = "course_id") Long courseId);

    public void assignTeacherToCourseById(@WebParam(name = "teacher_id") Long teacherId, @WebParam(name = "course_id") Long courseId);

    public CoursesResponse getAllCourses();
    
    public StudentsResponse getAllStudents();
    
    public TeachersResponse getAllTeachers();
}
