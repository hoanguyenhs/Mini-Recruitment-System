/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Phasedetail;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class PhaseDetailDAOImpl extends AbstractDAOImpl<Phasedetail, String>
	implements PhaseDetailDAO {

    /**
     * @param entityClass
     */
    protected PhaseDetailDAOImpl() {
	super(Phasedetail.class);
    }

}
