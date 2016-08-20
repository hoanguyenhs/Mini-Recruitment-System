package com.nthrms.pojo;

// Generated Jul 1, 2014 1:34:20 AM by Hibernate Tools 3.4.0.CR1

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

/**
 * Phase generated by hbm2java
 */
@Entity
@Table(name = "phase", catalog = "nthrms")
public class Phase implements java.io.Serializable {

    private Integer id;
    private Vacancy vacancy;
    private String name;
    private Integer total;
    private Integer pass;
    private Integer reject;
    private Integer waiting;
    private Set<Phasedetail> phasedetails = new HashSet<Phasedetail>(0);
    private Set<History> histories = new HashSet<History>(0);

    public Phase() {
    }

    public Phase(Vacancy vacancy) {
	this.vacancy = vacancy;
    }

    public Phase(Vacancy vacancy, String name, Integer total, Integer pass,
	    Integer reject, Integer waiting, Set<Phasedetail> phasedetails,
	    Set<History> histories) {
	this.vacancy = vacancy;
	this.name = name;
	this.total = total;
	this.pass = pass;
	this.reject = reject;
	this.waiting = waiting;
	this.phasedetails = phasedetails;
	this.histories = histories;
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
    @JoinColumn(name = "VacancyID", nullable = false)
    public Vacancy getVacancy() {
	return this.vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
	this.vacancy = vacancy;
    }

    @Column(name = "Name", length = 100)
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column(name = "Total")
    public Integer getTotal() {
	return this.total;
    }

    public void setTotal(Integer total) {
	this.total = total;
    }

    @Column(name = "Pass")
    public Integer getPass() {
	return this.pass;
    }

    public void setPass(Integer pass) {
	this.pass = pass;
    }

    @Column(name = "Reject")
    public Integer getReject() {
	return this.reject;
    }

    public void setReject(Integer reject) {
	this.reject = reject;
    }

    @Column(name = "Waiting")
    public Integer getWaiting() {
	return this.waiting;
    }

    public void setWaiting(Integer waiting) {
	this.waiting = waiting;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phase")
    public Set<Phasedetail> getPhasedetails() {
	return this.phasedetails;
    }

    public void setPhasedetails(Set<Phasedetail> phasedetails) {
	this.phasedetails = phasedetails;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phase")
    public Set<History> getHistories() {
	return this.histories;
    }

    public void setHistories(Set<History> histories) {
	this.histories = histories;
    }

}