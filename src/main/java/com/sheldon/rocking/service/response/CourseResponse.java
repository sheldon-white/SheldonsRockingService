package com.sheldon.rocking.service.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sheldon.rocking.service.dao.entity.Course;

public class CourseResponse extends BaseResponse {

    @XmlElement(required = true, name = "course")
    private Course course;

    public CourseResponse() {
    	
    }
    
    public CourseResponse(Course course) {
    	this.course = course;
    }
    
//	public List<Course> getCourses() {
//		return courses;
//	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
