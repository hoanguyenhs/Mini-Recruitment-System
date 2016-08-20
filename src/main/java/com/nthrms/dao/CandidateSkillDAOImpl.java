/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Candidateskill;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class CandidateSkillDAOImpl extends
	AbstractDAOImpl<Candidateskill, String> implements CandidateSkillDAO {

    /**
     * @param entityClass
     */
    protected CandidateSkillDAOImpl() {
	super(Candidateskill.class);
    }

}