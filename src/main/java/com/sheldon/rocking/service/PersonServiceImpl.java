package com.sheldon.rocking.service;

import javax.jws.WebService;

import com.sheldon.rocking.service.course.Course;
import com.sheldon.rocking.service.dao.CourseDao;

@WebService(endpointInterface = "com.sheldon.rocking.service.PersonService")
public class PersonServiceImpl implements PersonService {

	private CourseDao courseDao = null;
	
    public String greetPerson(String name) {
        Person person = new Person(name);

        return "Hello " + person.getName() + "!";
    }

    public Course findCourse(Long courseId) {
        Course course = courseDao.findById(courseId);

        return course;
    }

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

}
