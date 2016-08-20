/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.Position;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class PositionDAOImpl extends AbstractDAOImpl<Position, String>
	implements PositionDAO {

    /**
     * @param entityClass
     */
    protected PositionDAOImpl() {
	super(Position.class);
    }

}
