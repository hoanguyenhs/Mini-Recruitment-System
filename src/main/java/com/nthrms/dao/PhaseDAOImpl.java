/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Phase;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class PhaseDAOImpl extends AbstractDAOImpl<Phase, String> implements
	PhaseDAO {

    /**
     * @param entityClass
     */
    protected PhaseDAOImpl() {
	super(Phase.class);
    }

}
