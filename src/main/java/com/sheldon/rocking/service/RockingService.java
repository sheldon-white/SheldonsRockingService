package com.sheldon.rocking.service;

import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sheldon.rocking.service.dataobject.Course;
import com.sheldon.rocking.service.response.CoursesResponse;

@WebService
public interface RockingService {

	@XmlElement(required = true, name = "name")
    public String greetPerson(String name);

	@XmlElement(required = true, name = "course_id")
    public Course findCourse(Long courseId);
    
    public CoursesResponse getAllCourses();
}
