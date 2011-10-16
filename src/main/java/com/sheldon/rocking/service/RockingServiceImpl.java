package com.sheldon.rocking.service;

import javax.jws.WebService;

import com.sheldon.rocking.service.dao.CourseDao;
import com.sheldon.rocking.service.dataobject.Course;
import com.sheldon.rocking.service.dataobject.Person;
import com.sheldon.rocking.service.response.CoursesResponse;

@WebService(endpointInterface = "com.sheldon.rocking.service.RockingService")
public class RockingServiceImpl implements RockingService {

	private CourseDao courseDao = null;
	
    public String greetPerson(String name) {
        Person person = new Person(name);

        return "Hello " + person.getName() + "!";
    }

    public Course findCourse(Long courseId) {
        Course course = courseDao.findById(courseId);

        return course;
    }

    public CoursesResponse getAllCourses()
    {
    	return new CoursesResponse(courseDao.findAll());
    }
    
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

}
