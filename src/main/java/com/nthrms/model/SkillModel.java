/**
 * 
 */
package com.nthrms.model;

/**
 * @author Hoa Nguyen
 * 
 */
public class SkillModel {

    private Integer id;
    private String name;
    private String type;
    private Integer level = 1;
    private Integer idPosition;
    private Integer idCandidate;

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
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the level
     */
    public Integer getLevel() {
	return level;
    }

    /**
     * @param level
     *            the level to set
     */
    public void setLevel(Integer level) {
	this.level = level;
    }

    /**
     * @return the idPosition
     */
    public Integer getIdPosition() {
	return idPosition;
    }

    /**
     * @param idPosition
     *            the idPosition to set
     */
    public void setIdPosition(Integer idPosition) {
	this.idPosition = idPosition;
    }

    /**
     * @return the idCandidate
     */
    public Integer getIdCandidate() {
	return idCandidate;
    }

    /**
     * @param idCandidate
     *            the idCandidate to set
     */
    public void setIdCandidate(Integer idCandidate) {
	this.idCandidate = idCandidate;
    }
}
