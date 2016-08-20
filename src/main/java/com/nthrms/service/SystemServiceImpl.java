/**
 * 
 */
package com.nthrms.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nthrms.dao.UserDAO;
import com.nthrms.model.UserModel;
import com.nthrms.pojo.User;

/**
 * @author Hoa Nguyen
 * 
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private UserDAO userDAO;

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.SystemService#getUserbyUsername(java.lang.String)
     */
    @Transactional(readOnly = true)
    public UserModel getUserbyUsername(String username) {
	List<User> users = userDAO.getByCriteria(Restrictions.like("username",
		username));
	User user = users.get(0);
	UserModel userModel = toModel(user);
	return userModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.SystemService#checkUserNewPassword(java.lang.String,
     * java.lang.String)
     */
    @Transactional(readOnly = true)
    public boolean checkUserNewPassword(UserModel userModel, String username) {
	UserModel userModelDB = getUserbyUsername(username);
	userModel.setId(userModelDB.getId());
	return !userModel.getOldPassword().equals(userModelDB.getPassword());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.SystemService#updateUserPassword(com.nthrms.model.
     * UserModel)
     */
    @Transactional(readOnly = false)
    public boolean updateUserPassword(UserModel userModel) {
	User user = toPojo(userModel);
	userDAO.saveOrUpdate(user);
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.SystemService#toModel(com.nthrms.pojo.User)
     */
    public UserModel toModel(User user) {
	UserModel userModel = new UserModel();
	userModel.setId(user.getId());
	// userModel.setPositionId(user.getPosition().getId());
	// userModel.setPositionName(user.getPosition().getName());
	userModel.setUsername(user.getUsername());
	userModel.setPassword(user.getPassword());
	userModel.setPhone(user.getPhone());
	userModel.setEmail(user.getEmail());
	userModel.setActive(user.getActive());
	userModel.setRole(user.getRole());
	return userModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.SystemService#toPojo(com.nthrms.model.UserModel)
     */
    public User toPojo(UserModel userModel) {
	User user = userDAO.getById(userModel.getId().toString());
	user.setPassword(userModel.getPassword());
	return user;
    }

}
