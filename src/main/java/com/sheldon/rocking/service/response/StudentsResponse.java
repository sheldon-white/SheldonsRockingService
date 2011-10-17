package com.sheldon.rocking.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sheldon.rocking.service.dao.entity.Course;
import com.sheldon.rocking.service.dao.entity.Student;

public class StudentsResponse {

    @XmlElementWrapper(name = "students")
    @XmlElement(required = true, name = "student")
    private List<Student> students;

    public StudentsResponse() {
    	
    }
    
    public StudentsResponse(List<Student> students) {
    	this.students = students;
    }
    
//	public List<Course> getCourses() {
//		return courses;
//	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
