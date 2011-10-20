package com.sheldon.rocking.service.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.sheldon.rocking.service.dao.entity.Course;

public class BaseResponse {

    private Integer status;
    private String message;
    
    public BaseResponse() {
    	status = 0;
    	message = "OK";
    }
    
    public BaseResponse(Integer status, String message) {
    	this.setStatus(status);
    	this.setMessage(message);
    }

    @XmlElement(required = true, name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    @XmlElement(required = false, name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
