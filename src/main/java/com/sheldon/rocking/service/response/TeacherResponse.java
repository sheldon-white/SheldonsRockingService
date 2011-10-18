package com.sheldon.rocking.service.response;

import javax.xml.bind.annotation.XmlElement;

import com.sheldon.rocking.service.dao.entity.Teacher;

public class TeacherResponse {

    @SuppressWarnings("unused")
	@XmlElement(required = true, name = "teacher")
    private Teacher teacher;

    public TeacherResponse() {
    	
    }
    
    public TeacherResponse(Teacher teacher) {
    	this.teacher = teacher;
    }

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
