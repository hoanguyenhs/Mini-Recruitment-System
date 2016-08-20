/**
 * 
 */
package com.nthrms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nthrms.dao.PositionDAO;
import com.nthrms.dao.SkillDAO;
import com.nthrms.dao.PositionSkillDAO;
import com.nthrms.model.PositionModel;
import com.nthrms.pojo.Position;
import com.nthrms.pojo.Positionskill;

/**
 * @author Hoa Nguyen
 * 
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDAO positionDAO;

    @Autowired
    private PositionSkillDAO positionSkillDAO;

    @Autowired
    private SkillDAO skillDAO;

    @Autowired
    private SkillService skillService;

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.PositionService#getAllPosition()
     */
    @Transactional(readOnly = true)
    public List<PositionModel> getAllPosition() {
	List<Position> positionList = positionDAO.getAll();
	List<PositionModel> positionModelList = new ArrayList<PositionModel>();
	for (Position item : positionList) {
	    positionModelList.add(toModel(item));
	}
	return positionModelList;
    }

    @Transactional(readOnly = true)
    public List<PositionModel> getActivedPosition() {
	List<Position> positionList = positionDAO.getByCriteria(Restrictions
		.like("status", "Actived"));
	List<PositionModel> positionModelList = new ArrayList<PositionModel>();
	for (Position item : positionList) {
	    positionModelList.add(toModel(item));
	}
	return positionModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.PositionService#getById(java.lang.Integer)
     */
    @Transactional(readOnly = true)
    public PositionModel getById(Integer id) {
	Position position = positionDAO.getById(id.toString());
	PositionModel positionModel = toModel(position);
	return positionModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.PositionService#getById(java.lang.Integer)
     */
    @Transactional(readOnly = true)
    public PositionModel getByName(String name) {
	List<Position> positionList = positionDAO.getByCriteria(Restrictions
		.like("name", name));
	if (positionList.size() == 0) {
	    return new PositionModel();
	} else {
	    PositionModel positionModel = toModel(positionList.get(0));
	    return positionModel;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.PositionService#toPojo(com.nthrms.model.PositionModel,
     * java.lang.String[], java.lang.String[])
     */
    public Position toPojo(PositionModel positionModel) {
	Position position = new Position();
	position.setName(positionModel.getName());
	position.setYearOfExperience(positionModel.getYearOfExperience());
	position.setDivision(positionModel.getDivision());
	if (positionModel.getDescription().equals("")) {
	    position.setDescription("None");
	} else {
	    position.setDescription(positionModel.getDescription());
	}
	return position;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.PositionService#toModel(com.nthrms.pojo.Position)
     */
    public PositionModel toModel(Position position) {
	PositionModel positionModel = new PositionModel();
	positionModel.setId(position.getId());
	positionModel.setName(position.getName());
	positionModel.setYearOfExperience(position.getYearOfExperience());
	positionModel.setDivision(position.getDivision());
	positionModel.setStatus(position.getStatus());
	positionModel.setDescription(position.getDescription());
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss");
	positionModel.setCreateDate(simpleDateFormat.format(position
		.getCreateDate()));
	positionModel.setLastUpdate(simpleDateFormat.format(position
		.getLastUpdate()));
	return positionModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.PositionService#create(com.nthrms.pojo.Position)
     */
    @Transactional(readOnly = false)
    public void create(PositionModel positionModel, String[] idList,
	    String[] levelList) {
	Position position = toPojo(positionModel);
	position.setStatus("Waiting");
	position.setCreateDate(new Date());
	position.setLastUpdate(new Date());
	positionDAO.saveOrUpdate(position);
	for (int i = 0; i < idList.length; i++) {
	    Positionskill positionSkill = new Positionskill();
	    positionSkill.setPosition(position);
	    positionSkill.setSkill(skillDAO.getById(idList[i]));
	    positionSkill.setLevel(Integer.parseInt(levelList[i]));
	    positionSkillDAO.saveOrUpdate(positionSkill);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.PositionService#edit(com.nthrms.model.PositionModel,
     * java.lang.String[], java.lang.String[])
     */
    @Transactional(readOnly = false)
    public void edit(PositionModel positionModel, String[] idList,
	    String[] levelList, String[] idPositionList) {
	Position position = toPojo(positionModel);
	position.setId(positionModel.getId());
	position.setStatus("Waiting");
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss");
	try {
	    position.setCreateDate(simpleDateFormat.parse(positionModel
		    .getCreateDate()));
	} catch (Exception e) {
	}
	position.setLastUpdate(new Date());
	positionDAO.saveOrUpdate(position);
	for (int i = 0; i < idPositionList.length; i++) {
	    Positionskill positionSkill = positionSkillDAO
		    .getById(idPositionList[i]);
	    positionSkillDAO.delete(positionSkill);
	}
	for (int i = 0; i < idPositionList.length; i++) {
	    Positionskill positionSkill = new Positionskill();
	    positionSkill.setPosition(position);
	    positionSkill.setSkill(skillDAO.getById(idList[i]));
	    positionSkill.setLevel(Integer.parseInt(levelList[i]));
	    positionSkillDAO.saveOrUpdate(positionSkill);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.PositionService#delete(com.nthrms.model.PositionModel)
     */
    @Transactional(readOnly = false)
    public void delete(PositionModel positionModel) {
	Position position = toPojo(positionModel);
	position.setId(positionModel.getId());
	List<Positionskill> positionSkillList = positionSkillDAO
		.getByCriteria(Restrictions.like("position", position));
	for (Positionskill item : positionSkillList) {
	    positionSkillDAO.delete(item);
	}
	positionDAO.delete(position);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.PositionService#clone(com.nthrms.model.PositionModel,
     * java.lang.String[], java.lang.String[])
     */
    @Transactional(readOnly = false)
    public void clone(PositionModel positionModel, String[] idList,
	    String[] levelList) {
	Position position = toPojo(positionModel);
	position.setStatus("Waiting");
	position.setCreateDate(new Date());
	position.setLastUpdate(new Date());
	positionDAO.saveOrUpdate(position);
	for (int i = 0; i < idList.length; i++) {
	    Positionskill positionSkill = new Positionskill();
	    positionSkill.setPosition(position);
	    positionSkill.setSkill(skillDAO.getById(idList[i]));
	    positionSkill.setLevel(Integer.parseInt(levelList[i]));
	    positionSkillDAO.saveOrUpdate(positionSkill);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.PositionService#status(java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void status(Integer id) {
	Position position = positionDAO.getById(id.toString());
	if (position.getStatus().equals("Waiting")) {
	    position.setStatus("Actived");
	    position.setLastUpdate(new Date());
	} else {
	    position.setStatus("Waiting");
	    position.setLastUpdate(new Date());
	}
	positionDAO.saveOrUpdate(position);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.PositionService#search(com.nthrms.model.PositionModel)
     */
    @Transactional(readOnly = true)
    public List<PositionModel> search(PositionModel positionModel) {
	List<Position> positionList = new ArrayList<Position>();
	List<Criterion> criterionList = new ArrayList<Criterion>();
	if (positionModel.getDivision().equals("Choose a division")) {
	    positionModel.setDivision("");
	}
	if (positionModel.getStatus().equals("Choose a status")) {
	    positionModel.setStatus("");
	}
	Criterion criterion1 = Restrictions.like("name",
		"%" + positionModel.getName() + "%");
	Criterion criterion2 = Restrictions.like("yearOfExperience", "%"
		+ positionModel.getYearOfExperience() + "%");
	Criterion criterion3 = Restrictions.like("division", "%"
		+ positionModel.getDivision() + "%");
	Criterion criterion4 = Restrictions.like("status",
		"%" + positionModel.getStatus() + "%");
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	criterionList.add(criterion3);
	criterionList.add(criterion4);
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	if (!positionModel.getCreateDate().equals("")) {
	    Criterion criterion5 = null;
	    try {
		criterion5 = Restrictions.ge("createDate",
			simpleDateFormat.parse(positionModel.getCreateDate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion5);
	}
	if (!positionModel.getLastUpdate().equals("")) {
	    Criterion criterion6 = null;
	    try {
		criterion6 = Restrictions.le("lastUpdate",
			simpleDateFormat.parse(positionModel.getLastUpdate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion6);
	}
	positionList = positionDAO.getByCriteria(criterionList);
	List<PositionModel> positionModelList = new ArrayList<PositionModel>();
	for (Position position : positionList) {
	    PositionModel positionModelTemp = toModel(position);
	    positionModelList.add(positionModelTemp);
	}
	return positionModelList;
    }

}
