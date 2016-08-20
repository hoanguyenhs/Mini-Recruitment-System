/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Candidate;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class CandidateDAOImpl extends AbstractDAOImpl<Candidate, String>
	implements CandidateDAO {

    /**
     * @param entityClass
     */
    protected CandidateDAOImpl() {
	super(Candidate.class);
    }

}
