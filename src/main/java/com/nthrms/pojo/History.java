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
 * History generated by hbm2java
 */
@Entity
@Table(name = "history", catalog = "nthrms")
public class History implements java.io.Serializable {

    private Integer id;
    private Candidate candidate;
    private Phase phase;
    private User user;
    private Date dateTime;
    private String description;

    public History() {
    }

    public History(Candidate candidate, Phase phase, User user) {
	this.candidate = candidate;
	this.phase = phase;
	this.user = user;
    }

    public History(Candidate candidate, Phase phase, User user, Date dateTime,
	    String description) {
	this.candidate = candidate;
	this.phase = phase;
	this.user = user;
	this.dateTime = dateTime;
	this.description = description;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PhaseID", nullable = false)
    public Phase getPhase() {
	return this.phase;
    }

    public void setPhase(Phase phase) {
	this.phase = phase;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    public User getUser() {
	return this.user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DateTime", length = 19)
    public Date getDateTime() {
	return this.dateTime;
    }

    public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
    }

    @Column(name = "Description", length = 1000)
    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
