/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Positionskill;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class PositionSkillDAOImpl extends AbstractDAOImpl<Positionskill, String>
	implements PositionSkillDAO {

    /**
     * @param entityClass
     */
    protected PositionSkillDAOImpl() {
	super(Positionskill.class);
    }

}
