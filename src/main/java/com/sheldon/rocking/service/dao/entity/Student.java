package com.sheldon.rocking.service.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    
    @XmlElement(required = true, name = "student_code")
    @Column(name = "student_code", length = 10, nullable = false)
    private String studentCode;
    
    @XmlElement(required = true, name = "name")
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    
//    @ManyToMany
//    @JoinTable(
//        name="student_course",
//        joinColumns={@JoinColumn(name="student_id", referencedColumnName="student_id")},
//        inverseJoinColumns={@JoinColumn(name="course_id", referencedColumnName="course_id")})
//    private List<Course> courses;
    
    public Student() {
    }
    
    public Student(String name) {
        this.name = name;
    }

    public Student(Student s) {
    	this.studentId = s.studentId;
    	this.studentCode = s.studentCode;
    	this.name = s.name;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}    
}
