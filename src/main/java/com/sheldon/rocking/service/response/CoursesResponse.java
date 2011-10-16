package com.sheldon.rocking.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sheldon.rocking.service.dataobject.Course;

public class CoursesResponse {

    @XmlElementWrapper(name = "courses")
    @XmlElement(required = true, name = "course")
    private List<Course> courses;

    public CoursesResponse() {
    	
    }
    
    public CoursesResponse(List<Course> courses) {
    	this.courses = courses;
    }
    
//	public List<Course> getCourses() {
//		return courses;
//	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
