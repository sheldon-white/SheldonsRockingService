package com.sheldon.rocking.service.dataobject;

import java.util.Date;

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

@XmlRootElement(name = "course")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "COURSE")
public class Course {

    @XmlElement(required = true, name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @XmlElement(required = true, name = "title")
    @Column(name = "TITLE", length = 100, nullable = false)
    private String title;

    @XmlElement(required = true, name = "begin_date")
    @Column(name = "BEGIN_DATE")
    private Date beginDate;

    @XmlElement(required = true, name = "end_date")
    @Column(name = "END_DATE")
    private Date endDate;

    @XmlElement(required = true, name = "fee")
    @Column(name = "FEE")
    private int fee;

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

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
