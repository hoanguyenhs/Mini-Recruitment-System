/**
 * 
 */
package com.nthrms.model;

/**
 * @author Hoa Nguyen
 * 
 */
public class ExperienceModel {
    private Integer id;
    private String position;
    private String company;
    private String salary;
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
     * @return the position
     */
    public String getPosition() {
	return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(String position) {
	this.position = position;
    }

    /**
     * @return the company
     */
    public String getCompany() {
	return company;
    }

    /**
     * @param company
     *            the company to set
     */
    public void setCompany(String company) {
	this.company = company;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
	return salary;
    }

    /**
     * @param salary
     *            the salary to set
     */
    public void setSalary(String salary) {
	this.salary = salary;
    }

    /**
     * @return the startString
     */
    public String getStartDate() {
	return startDate;
    }

    /**
     * @param startString
     *            the startString to set
     */
    public void setStartDate(String startDate) {
	this.startDate = startDate;
    }

    /**
     * @return the endString
     */
    public String getEndDate() {
	return endDate;
    }

    /**
     * @param endString
     *            the endString to set
     */
    public void setEndDate(String endDate) {
	this.endDate = endDate;
    }

}
