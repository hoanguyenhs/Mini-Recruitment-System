/**
 * 
 */
package com.nthrms.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Hoa Nguyen
 * 
 */
public class CandidateModel {
    private Integer id;
    @Size(min = 1, max = 40, message = "Please input first name with 1-40 characters as minimum and maximum.")
    private String firstName;
    @Size(min = 3, max = 100, message = "Please input last name with 3-100 characters as minimum and maximum.")
    private String lastName;
    private String password;
    @Size(min = 10, max = 11, message = "Please input phone with 10-11 characters as minimum and maximum.")
    private String phone;
    @Email(message = "Error email syntax")
    @NotEmpty(message = "Please input email")
    private String email;
    @Size(min = 10, max = 200, message = "Please input address with 10-200 characters as minimum and maximum.")
    private String address;
    private String link;
    private String status;
    private String description;
    private String createDate;
    private String lastUpdate;
    private boolean certificate;
    private boolean experience;

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
     * @return the firstName
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
	return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
	this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
	return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * @return the link
     */
    public String getLink() {
	return link;
    }

    /**
     * @param link
     *            the link to set
     */
    public void setLink(String link) {
	this.link = link;
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
     * @return the certificate
     */
    public boolean isCertificate() {
	return certificate;
    }

    /**
     * @param certificate
     *            the certificate to set
     */
    public void setCertificate(boolean certificate) {
	this.certificate = certificate;
    }

    /**
     * @return the experience
     */
    public boolean isExperience() {
	return experience;
    }

    /**
     * @param experience
     *            the experience to set
     */
    public void setExperience(boolean experience) {
	this.experience = experience;
    }
}
