package com.nthrms.pojo;

// Generated Jul 1, 2014 1:34:20 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Candidateskill generated by hbm2java
 */
@Entity
@Table(name = "candidateskill", catalog = "nthrms")
public class Candidateskill implements java.io.Serializable {

    private Integer id;
    private Skill skill;
    private Candidate candidate;
    private Integer level;

    public Candidateskill() {
    }

    public Candidateskill(Skill skill, Candidate candidate) {
	this.skill = skill;
	this.candidate = candidate;
    }

    public Candidateskill(Skill skill, Candidate candidate, Integer level) {
	this.skill = skill;
	this.candidate = candidate;
	this.level = level;
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
    @JoinColumn(name = "SkillID", nullable = false)
    public Skill getSkill() {
	return this.skill;
    }

    public void setSkill(Skill skill) {
	this.skill = skill;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CandidateID", nullable = false)
    public Candidate getCandidate() {
	return this.candidate;
    }

    public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
    }

    @Column(name = "Level")
    public Integer getLevel() {
	return this.level;
    }

    public void setLevel(Integer level) {
	this.level = level;
    }

}
