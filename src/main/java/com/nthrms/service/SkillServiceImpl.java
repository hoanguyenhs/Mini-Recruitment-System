/**
 * 
 */
package com.nthrms.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nthrms.dao.CandidateDAO;
import com.nthrms.dao.CandidateSkillDAO;
import com.nthrms.dao.PositionDAO;
import com.nthrms.dao.PositionSkillDAO;
import com.nthrms.dao.SkillDAO;
import com.nthrms.model.SkillModel;
import com.nthrms.pojo.Candidate;
import com.nthrms.pojo.Candidateskill;
import com.nthrms.pojo.Position;
import com.nthrms.pojo.Positionskill;
import com.nthrms.pojo.Skill;

/**
 * @author Hoa Nguyen
 * 
 */
@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDAO skillDAO;

    @Autowired
    private PositionDAO positionDAO;

    @Autowired
    private PositionSkillDAO positionSkillDAO;

    @Autowired
    private CandidateDAO candidateDAO;

    @Autowired
    private CandidateSkillDAO candidateSkillDAO;

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.SkillService#getAllSkillModel()
     */
    @Transactional(readOnly = true)
    public List<SkillModel> getAllSkillModel() {
	List<Skill> skillList = skillDAO.getAll();
	List<SkillModel> skillModelList = new ArrayList<SkillModel>();
	for (Skill skillItem : skillList) {
	    SkillModel skillModel = new SkillModel();
	    skillModel.setId(skillItem.getId());
	    skillModel.setName(skillItem.getName());
	    skillModel.setType(skillItem.getType());
	    skillModelList.add(skillModel);
	}
	return skillModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.SkillService#getAllSkillOfPosition(java.lang.Integer)
     */
    @Transactional(readOnly = true)
    public List<SkillModel> getAllSkillOfPosition(Integer id) {
	Position position = positionDAO.getById(id.toString());
	List<Positionskill> positionSkillList = positionSkillDAO
		.getByCriteria(Restrictions.like("position", position));
	List<SkillModel> skillModelList = new ArrayList<SkillModel>();
	for (Positionskill item : positionSkillList) {
	    SkillModel skillModel = new SkillModel();
	    skillModel.setIdPosition(item.getId());
	    skillModel.setId(item.getSkill().getId());
	    skillModel.setName(item.getSkill().getName());
	    skillModel.setType(item.getSkill().getType());
	    skillModel.setLevel(item.getLevel());
	    skillModelList.add(skillModel);
	}
	return skillModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.SkillService#getAllSkillOfCandidate(java.lang.Integer)
     */
    @Transactional(readOnly = true)
    public List<SkillModel> getAllSkillOfCandidate(Integer id) {
	Candidate candidate = candidateDAO.getById(id.toString());
	List<Candidateskill> candidateskillList = candidateSkillDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	List<SkillModel> skillModelList = new ArrayList<SkillModel>();
	for (Candidateskill item : candidateskillList) {
	    SkillModel skillModel = new SkillModel();
	    skillModel.setIdCandidate(item.getId());
	    skillModel.setId(item.getSkill().getId());
	    skillModel.setName(item.getSkill().getName());
	    skillModel.setType(item.getSkill().getType());
	    skillModel.setLevel(item.getLevel());
	    skillModelList.add(skillModel);
	}
	return skillModelList;
    }

}
