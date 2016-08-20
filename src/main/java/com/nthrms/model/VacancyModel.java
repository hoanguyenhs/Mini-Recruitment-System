/**
 * 
 */
package com.nthrms.model;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

/**
 * @author Hoa Nguyen
 * 
 */
public class VacancyModel {

    private Integer id;
    @Size(min = 6, max = 50, message = "Please input name with 6-40 characters.")
    private String name;
    @DecimalMin(value = "1", message = "Please input a number greater than zero.")
    private Integer amount;
    private Integer positionId;
    private String positionName;
    private String startDate;
    private String endDate;
    private String status;
    private String description;
    private String createDate;
    private String lastUpdate;

    @SuppressWarnings("unused")
    private boolean positionNameValidated;

    @AssertFalse(message = "Please choose a position.")
    public boolean isPositionNameValidated() {
	boolean temp = false;
	if (positionName == null || positionName.equals("Choose a position")) {
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
     * @return the amount
     */
    public Integer getAmount() {
	return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(Integer amount) {
	this.amount = amount;
    }

    /**
     * @return the positionId
     */
    public Integer getPositionId() {
	return positionId;
    }

    /**
     * @param positionId
     *            the positionId to set
     */
    public void setPositionId(Integer positionId) {
	this.positionId = positionId;
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
     * @return the descripttion
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param descripttion
     *            the descripttion to set
     */
    public void setDescription(String description) {
	this.description = description;
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

    /**
     * @return the positionName
     */
    public String getPositionName() {
	return positionName;
    }

    /**
     * @param positionName
     *            the positionName to set
     */
    public void setPositionName(String positionName) {
	this.positionName = positionName;
    }

}
