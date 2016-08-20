/**
 * 
 */
package com.nthrms.model;

/**
 * @author Hoa Nguyen
 * 
 */
public class CertificateModel {

    private Integer id;
    private String name;
    private String school;
    private String score;
    private String startDate;
    private String endDate;

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the school
     */
    public String getSchool() {
	return school;
    }

    /**
     * @param school
     *            the school to set
     */
    public void setSchool(String school) {
	this.school = school;
    }

    /**
     * @return the score
     */
    public String getScore() {
	return score;
    }

    /**
     * @param score
     *            the score to set
     */
    public void setScore(String score) {
	this.score = score;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
	return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(String startDate) {
	this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
	return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(String endDate) {
	this.endDate = endDate;
    }

}
