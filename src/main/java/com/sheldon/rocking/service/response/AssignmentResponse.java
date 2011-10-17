package com.sheldon.rocking.service.response;

import javax.xml.bind.annotation.XmlElement;

import com.sheldon.rocking.service.dao.entity.Student;

public class AssignmentResponse {

    @SuppressWarnings("unused")
	@XmlElement(required = true, name = "assignment_id")
    private Long assignmentId;

    public AssignmentResponse() {
    	
    }
    
    public AssignmentResponse(Long assignmentId) {
    	this.assignmentId = assignmentId;
    }
}
