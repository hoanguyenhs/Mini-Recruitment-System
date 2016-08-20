/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Skill;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class SkillDAOImpl extends AbstractDAOImpl<Skill, String> implements
	SkillDAO {

    /**
     * @param entityClass
     */
    protected SkillDAOImpl() {
	super(Skill.class);
    }

}
