package com.sheldon.rocking.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

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

	@XmlElement(required = true, name = "course_code")
    public CourseResponse findCourse(@WebParam(name = "course_code") String courseCode);
    
	@XmlElement(required = true, name = "student_code")
    public StudentResponse findStudent(@WebParam(name = "student_code") String studentCode);

	@XmlElement(required = true, name = "teacher_code")
    public TeacherResponse findTeacher(@WebParam(name = "teacher_code") String teacherCode);

	public CourseResponse addCourse(@WebParam(name = "course") Course course);

    public StudentResponse addStudent(@WebParam(name = "student") Student student);
    
    public TeacherResponse addTeacher(@WebParam(name = "teacher") Teacher teacher);
    
	@XmlElement(required = true, name = "course_code")
    public StudentsResponse findStudentsForCourse(@WebParam(name = "course_code") String courseCode);
    
	@XmlElement(required = true, name = "student_code")
    public CoursesResponse findCoursesForStudent(@WebParam(name = "student_code") String studentCode);
    
    @XmlElements({@XmlElement(required = true, name = "student_code"), @XmlElement(required = true, name = "course_code")})
    public AssignmentResponse enrollStudent(@WebParam(name = "student_code") String studentCode,
    											@WebParam(name = "course_code") String courseCode);

    @XmlElements({@XmlElement(required = true, name = "teacher_code"), @XmlElement(required = true, name = "course_code")})
    public void assignTeacherToCourse(@WebParam(name = "teacher_code") String teacherCode, @WebParam(name = "course_code") String courseCode);

    public CoursesResponse getAllCourses();
    
    public StudentsResponse getAllStudents();
    
    public TeachersResponse getAllTeachers();
}
