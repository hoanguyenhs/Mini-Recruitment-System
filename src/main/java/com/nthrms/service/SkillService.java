/**
 * 
 */
package com.nthrms.service;

import java.util.List;

import com.nthrms.model.SkillModel;

/**
 * @author Hoa Nguyen
 *
 */
public interface SkillService {

    List<SkillModel> getAllSkillModel();
    
    List<SkillModel> getAllSkillOfPosition(Integer id);
    
    List<SkillModel> getAllSkillOfCandidate(Integer id);
    
}
