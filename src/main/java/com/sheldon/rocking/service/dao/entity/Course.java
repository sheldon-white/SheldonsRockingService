package com.sheldon.rocking.service.dao.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "course")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @XmlElement(required = true, name = "course_code")
    @Column(name = "course_code", length = 10, nullable = false)
    private String courseCode;

    @XmlElement(required = true, name = "title")
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @XmlElement(required = true, name = "begin_date")
    @Column(name = "begin_date")
    private Date beginDate;

    @XmlElement(required = true, name = "end_date")
    @Column(name = "end_date")
    private Date endDate;

    @XmlElement(required = true, name = "fee")
    @Column(name = "fee")
    private int fee;

    @XmlElement(required = true, name = "teacher")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Course() {}

    public Course(String title, Date beginDate, Date endDate, int fee) {
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.fee = fee;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getFee() {
        return fee;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
