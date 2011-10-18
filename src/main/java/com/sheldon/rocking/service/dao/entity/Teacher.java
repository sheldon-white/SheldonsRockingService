package com.sheldon.rocking.service.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teacher")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;
    
    @XmlElement(required = true, name = "teacher_code")
    @Column(name = "teacher_code", length = 10, nullable = false)
    private String teacherCode;
    
    @XmlElement(required = true, name = "name")
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    
//    @ManyToMany
//    @JoinTable(
//        name="teacher_course",
//        joinColumns={@JoinColumn(name="teacher_id", referencedColumnName="teacher_id")},
//        inverseJoinColumns={@JoinColumn(name="course_id", referencedColumnName="course_id")})
//    private List<Course> courses;
    
    public Teacher() {
    }
    
    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(Teacher s) {
    	this.teacherId = s.teacherId;
    	this.teacherCode = s.teacherCode;
    	this.name = s.name;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}    
}
