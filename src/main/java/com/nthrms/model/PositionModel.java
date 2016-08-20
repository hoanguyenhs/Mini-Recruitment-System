/**
 * 
 */
package com.nthrms.model;

import javax.validation.constraints.*;

/**
 * @author Hoa Nguyen
 * 
 */
public class PositionModel {
    private Integer id;
    @Size(min = 6, max = 50, message = "Please input postion's name with 6-40 characters as minimum and maximum.")
    private String name = "";
    @Pattern(regexp = "[0-9][y][0-9][m]", message = "Please input year of experience with valid format [number]y[number]m.")
    private String yearOfExperience;
    private String division;
    private String status;
    private String description;
    private String createDate;
    private String lastUpdate;

    @SuppressWarnings("unused")
    private boolean divisionValidated;

    @AssertFalse(message = "Please choose a division.")
    public boolean isDivisionValidated() {
	boolean temp = false;
	if (division == null || division.equals("Choose a division")) {
	    temp = true;
	}
	return temp;
    }

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
     * @return the yearOfExperience
     */
    public String getYearOfExperience() {
	return yearOfExperience;
    }

    /**
     * @param yearOfExperience
     *            the yearOfExperience to set
     */
    public void setYearOfExperience(String yearOfExperience) {
	this.yearOfExperience = yearOfExperience;
    }

    /**
     * @return the division
     */
    public String getDivision() {
	return division;
    }

    /**
     * @param division
     *            the division to set
     */
    public void setDivision(String division) {
	this.division = division;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the status
     */
    public String getStatus() {
	return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
	this.status = status;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {
	return createDate;
    }

    /**
     * @param createDate
     *            the createDate to set
     */
    public void setCreateDate(String createDate) {
	this.createDate = createDate;
    }

    /**
     * @return the lastUpdate
     */
    public String getLastUpdate() {
	return lastUpdate;
    }

    /**
     * @param lastUpdate
     *            the lastUpdate to set
     */
    public void setLastUpdate(String lastUpdate) {
	this.lastUpdate = lastUpdate;
    }

}
