/**
 * 
 */
package com.nthrms.model;

import javax.validation.constraints.*;

/**
 * @author Hoa Nguyen
 * 
 */
public class UserModel {

    private Integer id;
    private Integer positionId;
    private String positionName;
    private String username;
    private String password;
    @Size(min = 6, max = 40, message = "Please input old password with 6-40 characters as minimum and maximum.")
    private String oldPassword;
    @Size(min = 6, max = 40, message = "Please input new password with 6-40 characters as minimum and maximum.")
    private String newPassword;
    @Size(min = 6, max = 40, message = "Please input retype password with 6-40 characters as minimum and maximum.")
    private String retypePassword;
    private String phone;
    private String email;
    private Integer active;
    private String role;

    @SuppressWarnings("unused")
    private boolean newPasswordDuplicate;

    @AssertTrue(message="New password and old password are the same, please input new passowrd.")
    public boolean isNewPasswordDuplicate() {
	boolean temp = false;
	if (newPassword == null || newPassword.length() < 6
		|| newPassword.length() > 40) {
	    temp = true;
	} else {
	    temp = !newPassword.equals(oldPassword);
	}
	return temp;
    }
    
    @SuppressWarnings("unused")
    private boolean retypePasswordNotMatch;
    
    @AssertTrue(message="Retype password and new password do not match, please try again.")
    public boolean isRetypePasswordNotMatch() {
	boolean temp = false;
	if (retypePassword == null || retypePassword.length() < 6
		|| retypePassword.length() > 40) {
	    temp = true;
	} else {
	    temp = retypePassword.equals(newPassword);
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

    /**
     * @return the username
     */
    public String getUsername() {
	return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
	this.username = username;
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
     * @return the newPassword
     */
    public String getNewPassword() {
	return newPassword;
    }

    /**
     * @param newPassword
     *            the newPassword to set
     */
    public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
    }

    /**
     * @return the retypePassword
     */
    public String getRetypePassword() {
	return retypePassword;
    }

    /**
     * @param retypePassword
     *            the retypePassword to set
     */
    public void setRetypePassword(String retypePassword) {
	this.retypePassword = retypePassword;
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
     * @return the active
     */
    public Integer getActive() {
	return active;
    }

    /**
     * @param integer
     *            the active to set
     */
    public void setActive(Integer integer) {
	this.active = integer;
    }

    /**
     * @return the role
     */
    public String getRole() {
	return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
	this.role = role;
    }

    /**
     * @return the oldPassword
     */
    public String getOldPassword() {
	return oldPassword;
    }

    /**
     * @param oldPassword
     *            the oldPassword to set
     */
    public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
    }

}
