/**
 * 
 */
package com.nthrms.service;

import com.nthrms.model.UserModel;
import com.nthrms.pojo.User;

/**
 * @author Hoa Nguyen
 *
 */
public interface SystemService {
    UserModel getUserbyUsername(String username);
    
    boolean checkUserNewPassword(UserModel userModel, String username);
    
    boolean updateUserPassword(UserModel userModel);
    
    UserModel toModel(User user);
    
    User toPojo(UserModel userModel);
}
