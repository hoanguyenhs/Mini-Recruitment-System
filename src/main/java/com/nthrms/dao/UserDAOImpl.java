/**
 * 
 */
package com.nthrms.dao;

import org.springframework.stereotype.Repository;

import com.nthrms.pojo.User;

/**
 * @author Hoa Nguyen
 * 
 */
@Repository
public class UserDAOImpl extends AbstractDAOImpl<User, String> implements
	UserDAO {
    
    /**
     * @param entityClass
     */
    protected UserDAOImpl() {
	super(User.class);
    }

}
