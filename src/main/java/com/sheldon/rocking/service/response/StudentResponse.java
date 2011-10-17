package com.sheldon.rocking.service.response;

import javax.xml.bind.annotation.XmlElement;

import com.sheldon.rocking.service.dao.entity.Student;

public class StudentResponse {

    @SuppressWarnings("unused")
	@XmlElement(required = true, name = "student")
    private Student student;

    public StudentResponse() {
    	
    }
    
    public StudentResponse(Student student) {
    	this.student = student;
    }
    
//	public List<Student> getStudents() {
//		return Students;
//	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
