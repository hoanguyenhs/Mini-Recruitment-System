package com.nthrms.pojo;

// Generated Jul 1, 2014 1:34:20 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vacancy generated by hbm2java
 */
@Entity
@Table(name = "vacancy", catalog = "nthrms")
public class Vacancy implements java.io.Serializable {

    private Integer id;
    private Position position;
    private String name;
    private Integer amount;
    private Date startDate;
    private Date endDate;
    private String status;
    private String description;
    private Date createDate;
    private Date lastUpdate;
    private Set<Phase> phases = new HashSet<Phase>(0);

    public Vacancy() {
    }

    public Vacancy(Position position) {
	this.position = position;
    }

    public Vacancy(Position position, String name, Integer amount,
	    Date startDate, Date endDate, String status, String description,
	    Date createDate, Date lastUpdate, Set<Phase> phases) {
	this.position = position;
	this.name = name;
	this.amount = amount;
	this.startDate = startDate;
	this.endDate = endDate;
	this.status = status;
	this.description = description;
	this.createDate = createDate;
	this.lastUpdate = lastUpdate;
	this.phases = phases;
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
    @JoinColumn(name = "PositionID", nullable = false)
    public Position getPosition() {
	return this.position;
    }

    public void setPosition(Position position) {
	this.position = position;
    }

    @Column(name = "Name", length = 45)
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column(name = "Amount")
    public Integer getAmount() {
	return this.amount;
    }

    public void setAmount(Integer amount) {
	this.amount = amount;
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

    @Column(name = "Status", length = 45)
    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    @Column(name = "Description", length = 1000)
    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate", length = 19)
    public Date getCreateDate() {
	return this.createDate;
    }

    public void setCreateDate(Date createDate) {
	this.createDate = createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LastUpdate", length = 19)
    public Date getLastUpdate() {
	return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
	this.lastUpdate = lastUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vacancy")
    public Set<Phase> getPhases() {
	return this.phases;
    }

    public void setPhases(Set<Phase> phases) {
	this.phases = phases;
    }

}