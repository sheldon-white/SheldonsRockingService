package com.sheldon.rocking.service;

import javax.jws.WebService;

import com.sheldon.rocking.service.dao.CourseDao;
import com.sheldon.rocking.service.dao.StudentCourseDao;
import com.sheldon.rocking.service.dao.StudentDao;
import com.sheldon.rocking.service.dao.TeacherDao;
import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;
import com.sheldon.rocking.service.dao.entity.StudentCourse;
import com.sheldon.rocking.service.dao.entity.Teacher;
import com.sheldon.rocking.service.response.AssignmentResponse;
import com.sheldon.rocking.service.response.CourseResponse;
import com.sheldon.rocking.service.response.CoursesResponse;
import com.sheldon.rocking.service.response.StudentResponse;
import com.sheldon.rocking.service.response.StudentsResponse;
import com.sheldon.rocking.service.response.TeacherResponse;
import com.sheldon.rocking.service.response.TeachersResponse;

@WebService(endpointInterface = "com.sheldon.rocking.service.RockingService")
@Timed
public class RockingServiceImpl implements RockingService {

	private CourseDao courseDao = null;
	private StudentDao studentDao = null;
	private TeacherDao teacherDao = null;
	private StudentCourseDao studentCourseDao = null;
	
    public CourseResponse findCourse(String courseCode) {
        return new CourseResponse(_findCourse(courseCode));
    }

    private Course _findCourse(String courseCode) {
    	return courseDao.find(courseCode);
    }
    
    public StudentResponse findStudent(String studentCode) {
        return new StudentResponse(_findStudent(studentCode));
    }

    private Student _findStudent(String studentCode) {
    	return studentDao.find(studentCode);
    }

    public TeacherResponse findTeacher(String teacherCode) {
        return new TeacherResponse(_findTeacher(teacherCode));
    }

    private Teacher _findTeacher(String teacherCode) {
    	return teacherDao.find(teacherCode);
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
    
    public TeacherResponse addTeacher(Teacher teacher) {
    	teacher.setTeacherId(null);
    	Teacher newTeacher = teacherDao.store(teacher);
    	return new TeacherResponse(newTeacher);
    }

    public AssignmentResponse enrollStudent(String studentCode, String courseCode) {
    	StudentCourse studentCourse = new StudentCourse(_findStudent(studentCode), _findCourse(courseCode));
    	StudentCourse newStudentCourse = studentCourseDao.store(studentCourse);
    	return new AssignmentResponse();
    }

    public void assignTeacherToCourse(String teacherCode, String courseCode) {
    	Teacher teacher = _findTeacher(teacherCode);
    	Course course = _findCourse(courseCode);
    	course.setTeacher(teacher);
    	courseDao.store(course);
    }

    public CoursesResponse getAllCourses()
    {
    	return new CoursesResponse(courseDao.findAll());
    }
    
    public StudentsResponse getAllStudents()
    {
    	return new StudentsResponse(studentDao.findAll());
    }
    
    public TeachersResponse getAllTeachers()
    {
    	return new TeachersResponse(teacherDao.findAll());
    }
    
    public StudentsResponse findStudentsForCourse(String courseCode) {
    	return new StudentsResponse(studentCourseDao.findStudentsForCourse(courseCode));  	
    }

    public CoursesResponse findCoursesForStudent(String studentCode) {
    	return new CoursesResponse(studentCourseDao.findCoursesForStudent(studentCode));  	
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

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
}
