package com.nthrms.pojo;

// Generated Jul 1, 2014 1:34:20 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Experience generated by hbm2java
 */
@Entity
@Table(name = "experience", catalog = "nthrms")
public class Experience implements java.io.Serializable {

    private Integer id;
    private Candidate candidate;
    private String position;
    private String company;
    private String salary;
    private Date startDate;
    private Date endDate;

    public Experience() {
    }

    public Experience(Candidate candidate) {
	this.candidate = candidate;
    }

    public Experience(Candidate candidate, String position, String company,
	    String salary, Date startDate, Date endDate) {
	this.candidate = candidate;
	this.position = position;
	this.company = company;
	this.salary = salary;
	this.startDate = startDate;
	this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CandidateID", nullable = false)
    public Candidate getCandidate() {
	return this.candidate;
    }

    public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
    }

    @Column(name = "Position", length = 100)
    public String getPosition() {
	return this.position;
    }

    public void setPosition(String position) {
	this.position = position;
    }

    @Column(name = "Company", length = 100)
    public String getCompany() {
	return this.company;
    }

    public void setCompany(String company) {
	this.company = company;
    }

    @Column(name = "Salary", length = 100)
    public String getSalary() {
	return this.salary;
    }

    public void setSalary(String salary) {
	this.salary = salary;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StartDate", length = 10)
    public Date getStartDate() {
	return this.startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EndDate", length = 10)
    public Date getEndDate() {
	return this.endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

}