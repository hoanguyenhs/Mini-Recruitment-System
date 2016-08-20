/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Experience;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class ExperienceDAOImpl extends AbstractDAOImpl<Experience, String>
	implements ExperienceDAO {

    /**
     * @param entityClass
     */
    protected ExperienceDAOImpl() {
	super(Experience.class);
    }

}