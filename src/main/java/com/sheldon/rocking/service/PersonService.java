package com.sheldon.rocking.service;

import javax.jws.WebService;

import com.sheldon.rocking.service.course.Course;

@WebService
public interface PersonService {

    public String greetPerson(String name);

    public Course findCourse(Long courseId);
}
