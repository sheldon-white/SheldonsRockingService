package com.sheldon.rocking.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.sheldon.rocking.service.dao.CourseDao;
import com.sheldon.rocking.service.dao.StudentCourseDao;
import com.sheldon.rocking.service.dao.StudentDao;
import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;
import com.sheldon.rocking.service.dao.entity.StudentCourse;
import com.sheldon.rocking.service.response.AssignmentResponse;
import com.sheldon.rocking.service.response.CourseResponse;
import com.sheldon.rocking.service.response.CoursesResponse;
import com.sheldon.rocking.service.response.StudentResponse;
import com.sheldon.rocking.service.response.StudentsResponse;

@WebService(endpointInterface = "com.sheldon.rocking.service.RockingService")
public class RockingServiceImpl implements RockingService {

	private CourseDao courseDao = null;
	private StudentDao studentDao = null;
	private StudentCourseDao studentCourseDao = null;
	
    public Course findCourse(Long courseId) {
        Course course = courseDao.findById(courseId);

        return course;
    }

    public Student findStudent(Long studentId) {
    	Student student = studentDao.findById(studentId);

        return student;
    }

    public CourseResponse addCourse(Course course) {
    	course.setCourseId(null);
    	Course newCourse = courseDao.store(course);
    	return new CourseResponse(newCourse);
    }

    public StudentResponse addStudent(Student student) {
    	student.setStudentId(null);
    	Student newStudent = studentDao.store(student);
    	return new StudentResponse(newStudent);
    }
    
    public AssignmentResponse enrollStudent(Student student, Course course) {
    	StudentCourse studentCourse = new StudentCourse(student, course);
    	StudentCourse newStudentCourse = studentCourseDao.store(studentCourse);
    	return new AssignmentResponse(newStudentCourse.getId());
    }

    public AssignmentResponse enrollStudentById(Long studentId, Long courseId) {
    	StudentCourse studentCourse = new StudentCourse(findStudent(studentId), findCourse(courseId));
    	StudentCourse newStudentCourse = studentCourseDao.store(studentCourse);
    	return new AssignmentResponse(newStudentCourse.getId());
    }

    public CoursesResponse getAllCourses()
    {
    	return new CoursesResponse(courseDao.findAll());
    }
    
    public StudentsResponse getAllStudents()
    {
    	return new StudentsResponse(studentDao.findAll());
    }
    
    public StudentsResponse findStudentsForCourse(Long courseId) {
    	return new StudentsResponse(studentCourseDao.findStudentsForCourse(courseId));  	
    }

    public CoursesResponse findCoursesForStudent(Long studentId) {
    	return new CoursesResponse(studentCourseDao.findCoursesForStudent(studentId));  	
    }

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public StudentCourseDao getStudentCourseDao() {
		return studentCourseDao;
	}

	public void setStudentCourseDao(StudentCourseDao studentCourseDao) {
		this.studentCourseDao = studentCourseDao;
	}

}
