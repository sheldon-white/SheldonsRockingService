package com.sheldon.rocking.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sheldon.rocking.service.dao.entity.Teacher;

public class TeachersResponse extends BaseResponse {

    @SuppressWarnings("unused")
	@XmlElementWrapper(name = "teachers")
    @XmlElement(required = true, name = "teacher")
    private List<Teacher> teachers;

    public TeachersResponse() {
    	
    }
    
    public TeachersResponse(List<Teacher> teachers) {
    	this.teachers = teachers;
    }

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
