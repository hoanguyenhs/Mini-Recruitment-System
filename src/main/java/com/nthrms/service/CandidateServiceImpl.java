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

import com.nthrms.dao.CandidateDAO;
import com.nthrms.dao.CandidateSkillDAO;
import com.nthrms.dao.CertificateDAO;
import com.nthrms.dao.ExperienceDAO;
import com.nthrms.dao.SkillDAO;
import com.nthrms.model.CandidateModel;
import com.nthrms.model.CertificateModel;
import com.nthrms.model.ExperienceModel;
import com.nthrms.pojo.Candidate;
import com.nthrms.pojo.Candidateskill;
import com.nthrms.pojo.Certificate;
import com.nthrms.pojo.Experience;

/**
 * @author Hoa Nguyen
 * 
 */
@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateDAO candidateDAO;

    @Autowired
    private CandidateSkillDAO candidateSkillDAO;

    @Autowired
    private SkillDAO skillDAO;

    @Autowired
    private CertificateDAO certificateDAO;

    @Autowired
    private ExperienceDAO experienceDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#toPojo(com.nthrms.model.CandidateModel
     * )
     */
    public Candidate toPojo(CandidateModel candidateModel) {
	Candidate candidate = new Candidate();
	if (candidateModel.getId() != null) {
	    candidate.setId(candidateModel.getId());
	}
	candidate.setFirstName(candidateModel.getFirstName());
	candidate.setLastName(candidateModel.getLastName());
	candidate.setPhone(candidateModel.getPhone());
	candidate.setEmail(candidateModel.getEmail());
	candidate.setAddress(candidateModel.getAddress());
	if (candidateModel.getLink() == null
		|| candidateModel.getLink().equals("")) {
	    candidate.setLink("None");
	} else {
	    candidate.setLink(candidateModel.getLink());
	}
	candidate.setStatus("Waiting");
	if (candidateModel.getDescription() == null
		|| candidateModel.getDescription().equals("")) {
	    candidate.setDescription("None");
	} else {
	    candidate.setDescription(candidateModel.getDescription());
	}
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss");
	if (candidateModel.getCreateDate() == null) {
	    candidate.setCreateDate(new Date());
	} else {
	    try {
		candidate.setCreateDate(simpleDateFormat.parse(candidateModel
			.getCreateDate()));
	    } catch (ParseException e) {
	    }
	}
	candidate.setLastUpdate(new Date());
	return candidate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#toModel(com.nthrms.pojo.Candidate)
     */
    public CandidateModel toModel(Candidate candidate) {
	CandidateModel candidateModel = new CandidateModel();
	candidateModel.setId(candidate.getId());
	candidateModel.setFirstName(candidate.getFirstName());
	candidateModel.setLastName(candidate.getLastName());
	candidateModel.setPhone(candidate.getPhone());
	candidateModel.setEmail(candidate.getEmail());
	candidateModel.setAddress(candidate.getAddress());
	candidateModel.setLink(candidate.getLink());
	candidateModel.setStatus(candidate.getStatus());
	candidateModel.setDescription(candidate.getDescription());
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss");
	candidateModel.setCreateDate(simpleDateFormat.format(candidate
		.getCreateDate()));
	candidateModel.setLastUpdate(simpleDateFormat.format(candidate
		.getLastUpdate()));
	return candidateModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#checkCertificate(java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[])
     */
    public boolean checkCertificate(String[] certificateName,
	    String[] certificateSchool, String[] certificateScore,
	    String[] certificateStarDate, String[] certificateEndDate) {
	if (certificateName.length == 0 || certificateSchool.length == 0
		|| certificateScore.length == 0
		|| certificateStarDate.length == 0
		|| certificateEndDate.length == 0) {
	    return false;
	} else {
	    return true;
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#checExperience(java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[])
     */
    public boolean checExperience(String[] experienceCompany,
	    String[] experiencePosition, String[] experienceSalary,
	    String[] experienceStarDate, String[] experienceEndDate) {
	if (experienceCompany.length == 0 || experiencePosition.length == 0
		|| experienceSalary.length == 0
		|| experienceStarDate.length == 0
		|| experienceEndDate.length == 0) {
	    return false;
	} else {
	    return true;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.CandidateService#getById(java.lang.Integer)
     */
    @Transactional(readOnly = true)
    public CandidateModel getById(Integer id) {
	CandidateModel candidateModel = toModel(candidateDAO.getById(id
		.toString()));
	return candidateModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.CandidateService#getIdbyEmail(java.lang.String)
     */
    @Transactional(readOnly = true)
    public int getIdbyEmail(String email) {
	List<Candidate> canidateList = candidateDAO.getByCriteria(Restrictions
		.like("email", email));
	return canidateList.get(0).getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.CandidateService#getByEmail(java.lang.String)
     */
    @Transactional(readOnly = true)
    public int countByEmail(String email) {
	List<Candidate> canidateList = candidateDAO.getByCriteria(Restrictions
		.like("email", email));
	return canidateList.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#create(com.nthrms.model.CandidateModel
     * , java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[], java.lang.String[])
     */
    @Transactional(readOnly = false)
    public void create(CandidateModel candidateModel, String[] certificateName,
	    String[] certificateSchool, String[] certificateScore,
	    String[] certificateStarDate, String[] certificateEndDate,
	    String[] experienceCompany, String[] experiencePosition,
	    String[] experienceSalary, String[] experienceStarDate,
	    String[] experienceEndDate, String[] idList, String[] levelList) {
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Candidate candidate = toPojo(candidateModel);
	candidateDAO.saveOrUpdate(candidate);
	for (int i = 0; i < idList.length; i++) {
	    Candidateskill candidateSkill = new Candidateskill();
	    candidateSkill.setCandidate(candidate);
	    candidateSkill.setSkill(skillDAO.getById(idList[i]));
	    candidateSkill.setLevel(Integer.parseInt(levelList[i]));
	    candidateSkillDAO.saveOrUpdate(candidateSkill);
	}
	for (int i = 0; i < certificateName.length; i++) {
	    if (!certificateName[i].equals("")
		    && !certificateSchool[i].equals("")
		    && !certificateScore[i].equals("")
		    && !certificateStarDate[i].equals("")
		    && !certificateEndDate[i].equals("")) {
		Certificate certificate = new Certificate();
		certificate.setCandidate(candidate);
		certificate.setName(certificateName[i]);
		certificate.setSchool(certificateSchool[i]);
		certificate.setScore(certificateScore[i]);
		try {
		    certificate.setStartDate(simpleDateFormat
			    .parse(certificateStarDate[i]));
		} catch (ParseException e) {
		}
		try {
		    certificate.setEndDate(simpleDateFormat
			    .parse(certificateEndDate[i]));
		} catch (ParseException e) {
		}
		certificateDAO.saveOrUpdate(certificate);
	    }
	}
	for (int i = 0; i < experienceCompany.length; i++) {
	    if (!experienceCompany[i].equals("")
		    && !experiencePosition[i].equals("")
		    && !experienceSalary[i].equals("")
		    && !experienceStarDate[i].equals("")
		    && !experienceEndDate[i].equals("")) {
		Experience experience = new Experience();
		experience.setCandidate(candidate);
		experience.setCompany(experienceCompany[i]);
		experience.setPosition(experiencePosition[i]);
		experience.setSalary(experienceSalary[i]);
		try {
		    experience.setStartDate(simpleDateFormat
			    .parse(experienceStarDate[i]));
		} catch (ParseException e) {
		}
		try {
		    experience.setEndDate(simpleDateFormat
			    .parse(experienceEndDate[i]));
		} catch (ParseException e) {
		}
		experienceDAO.saveOrUpdate(experience);
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#getAllCertificate(com.nthrms.model
     * .CandidateModel)
     */
    @Transactional(readOnly = true)
    public List<CertificateModel> getAllCertificate(
	    CandidateModel candidateModel) {
	Candidate candidate = toPojo(candidateModel);
	List<Certificate> certificateList = certificateDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	List<CertificateModel> certificateModelList = new ArrayList<CertificateModel>();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	for (Certificate item : certificateList) {
	    CertificateModel certificateModel = new CertificateModel();
	    certificateModel.setId(item.getId());
	    certificateModel.setName(item.getName());
	    certificateModel.setSchool(item.getSchool());
	    certificateModel.setScore(item.getScore());
	    certificateModel.setStartDate(simpleDateFormat.format(item
		    .getStartDate()));
	    certificateModel.setEndDate(simpleDateFormat.format(item
		    .getEndDate()));
	    certificateModelList.add(certificateModel);
	}
	return certificateModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#getAllExperience(com.nthrms.model
     * .CandidateModel)
     */
    @Transactional(readOnly = true)
    public List<ExperienceModel> getAllExperience(CandidateModel candidateModel) {
	Candidate candidate = toPojo(candidateModel);
	List<Experience> experienceList = experienceDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	List<ExperienceModel> experienceModelList = new ArrayList<ExperienceModel>();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	for (Experience item : experienceList) {
	    ExperienceModel experienceModel = new ExperienceModel();
	    experienceModel.setId(item.getId());
	    experienceModel.setCompany(item.getCompany());
	    experienceModel.setPosition(item.getPosition());
	    experienceModel.setSalary(item.getSalary());
	    experienceModel.setStartDate(simpleDateFormat.format(item
		    .getStartDate()));
	    experienceModel.setEndDate(simpleDateFormat.format(item
		    .getEndDate()));
	    experienceModelList.add(experienceModel);
	}
	return experienceModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.CandidateService#status(java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void status(Integer id) {
	Candidate candidate = candidateDAO.getById(id.toString());
	if (candidate.getStatus().equals("Waiting")) {
	    candidate.setStatus("Actived");
	    candidate.setLastUpdate(new Date());
	} else {
	    candidate.setStatus("Waiting");
	    candidate.setLastUpdate(new Date());
	}
	candidateDAO.saveOrUpdate(candidate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#edit(com.nthrms.model.CandidateModel,
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[],
     * java.lang.String[], java.lang.String[], java.lang.String[])
     */
    @Transactional(readOnly = false)
    public void edit(CandidateModel candidateModel, String[] certificateName,
	    String[] certificateSchool, String[] certificateScore,
	    String[] certificateStarDate, String[] certificateEndDate,
	    String[] experienceCompany, String[] experiencePosition,
	    String[] experienceSalary, String[] experienceStarDate,
	    String[] experienceEndDate, String[] idList, String[] levelList,
	    String[] idCandidateList) {
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Candidate candidate = toPojo(candidateModel);
	List<Certificate> certificateList = certificateDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	for (Certificate item : certificateList) {
	    certificateDAO.delete(item);
	}
	List<Experience> experienceList = experienceDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	for (Experience item : experienceList) {
	    experienceDAO.delete(item);
	}
	for (int i = 0; i < idCandidateList.length; i++) {
	    Candidateskill candidateSkill = candidateSkillDAO
		    .getById(idCandidateList[i]);
	    candidateSkillDAO.delete(candidateSkill);
	}
	candidateDAO.saveOrUpdate(candidate);
	for (int i = 0; i < idList.length; i++) {
	    Candidateskill candidateSkill = new Candidateskill();
	    candidateSkill.setCandidate(candidate);
	    candidateSkill.setSkill(skillDAO.getById(idList[i]));
	    candidateSkill.setLevel(Integer.parseInt(levelList[i]));
	    candidateSkillDAO.saveOrUpdate(candidateSkill);
	}
	for (int i = 0; i < certificateName.length; i++) {
	    if (!certificateName[i].equals("")
		    && !certificateSchool[i].equals("")
		    && !certificateScore[i].equals("")
		    && !certificateStarDate[i].equals("")
		    && !certificateEndDate[i].equals("")) {
		Certificate certificate = new Certificate();
		certificate.setCandidate(candidate);
		certificate.setName(certificateName[i]);
		certificate.setSchool(certificateSchool[i]);
		certificate.setScore(certificateScore[i]);
		try {
		    certificate.setStartDate(simpleDateFormat
			    .parse(certificateStarDate[i]));
		} catch (ParseException e) {
		}
		try {
		    certificate.setEndDate(simpleDateFormat
			    .parse(certificateEndDate[i]));
		} catch (ParseException e) {
		}
		certificateDAO.saveOrUpdate(certificate);
	    }
	}
	for (int i = 0; i < experienceCompany.length; i++) {
	    if (!experienceCompany[i].equals("")
		    && !experiencePosition[i].equals("")
		    && !experienceSalary[i].equals("")
		    && !experienceStarDate[i].equals("")
		    && !experienceEndDate[i].equals("")) {
		Experience experience = new Experience();
		experience.setCandidate(candidate);
		experience.setCompany(experienceCompany[i]);
		experience.setPosition(experiencePosition[i]);
		experience.setSalary(experienceSalary[i]);
		try {
		    experience.setStartDate(simpleDateFormat
			    .parse(experienceStarDate[i]));
		} catch (ParseException e) {
		}
		try {
		    experience.setEndDate(simpleDateFormat
			    .parse(experienceEndDate[i]));
		} catch (ParseException e) {
		}
		experienceDAO.saveOrUpdate(experience);
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.CandidateService#search(com.nthrms.model.CandidateModel
     * )
     */
    @Transactional(readOnly = true)
    public List<CandidateModel> search(CandidateModel candidateModel) {
	List<Candidate> candidateList = new ArrayList<Candidate>();
	List<Criterion> criterionList = new ArrayList<Criterion>();
	if (candidateModel.getStatus().equals("Choose a status")) {
	    candidateModel.setStatus("");
	}
	Criterion criterion1 = Restrictions.like("firstName", "%"
		+ candidateModel.getFirstName() + "%");
	Criterion criterion2 = Restrictions.like("lastName", "%"
		+ candidateModel.getLastName() + "%");
	Criterion criterion3 = Restrictions.like("phone",
		"%" + candidateModel.getPhone() + "%");
	Criterion criterion4 = Restrictions.like("email",
		"%" + candidateModel.getEmail() + "%");
	Criterion criterion5 = Restrictions.like("address", "%"
		+ candidateModel.getAddress() + "%");
	Criterion criterion6 = Restrictions.like("link",
		"%" + candidateModel.getLink() + "%");
	Criterion criterion7 = Restrictions.like("status",
		"%" + candidateModel.getStatus() + "%");
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	criterionList.add(criterion3);
	criterionList.add(criterion4);
	criterionList.add(criterion5);
	criterionList.add(criterion6);
	criterionList.add(criterion7);
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	if (!candidateModel.getCreateDate().equals("")) {
	    Criterion criterion8 = null;
	    try {
		criterion8 = Restrictions.ge("createDate",
			simpleDateFormat.parse(candidateModel.getCreateDate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion8);
	}
	if (!candidateModel.getLastUpdate().equals("")) {
	    Criterion criterion9 = null;
	    try {
		criterion9 = Restrictions.le("lastUpdate",
			simpleDateFormat.parse(candidateModel.getLastUpdate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion9);
	}
	candidateList = candidateDAO.getByCriteria(criterionList);
	List<CandidateModel> candidateModelList = new ArrayList<CandidateModel>();
	for (Candidate item : candidateList) {
	    candidateModelList.add(toModel(item));
	}
	return candidateModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.CandidateService#delete(java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void delete(CandidateModel candidateModel) {
	Candidate candidate = toPojo(candidateModel);
	List<Certificate> certificateList = certificateDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	for (Certificate item : certificateList) {
	    certificateDAO.delete(item);
	}
	List<Experience> experienceList = experienceDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	for (Experience item : experienceList) {
	    experienceDAO.delete(item);
	}
	List<Candidateskill> candidateSkillList = candidateSkillDAO
		.getByCriteria(Restrictions.like("candidate", candidate));
	for (Candidateskill item : candidateSkillList) {
	    candidateSkillDAO.delete(item);
	}
	candidateDAO.delete(candidate);
    }
}
