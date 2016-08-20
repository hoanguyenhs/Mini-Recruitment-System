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
import com.nthrms.dao.PhaseDAO;
import com.nthrms.dao.PhaseDetailDAO;
import com.nthrms.dao.PositionDAO;
import com.nthrms.dao.VacancyDAO;
import com.nthrms.model.CandidateModel;
import com.nthrms.model.SkillModel;
import com.nthrms.model.VacancyModel;
import com.nthrms.pojo.Candidate;
import com.nthrms.pojo.Phase;
import com.nthrms.pojo.Phasedetail;
import com.nthrms.pojo.Position;
import com.nthrms.pojo.Vacancy;

/**
 * @author Hoa Nguyen
 * 
 */
@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyDAO vacancyDAO;

    @Autowired
    private PositionDAO positionDAO;

    @Autowired
    private CandidateDAO candidateDAO;

    @Autowired
    private PhaseDAO phaseDAO;

    @Autowired
    private PhaseDetailDAO phaseDetailDAO;

    @Autowired
    private SkillService skillService;

    @Autowired
    private CandidateService candidateService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.VacancyService#toPojo(com.nthrms.model.VacancyModel)
     */
    public Vacancy toPojo(VacancyModel vacancyModel) {
	Vacancy vacancy = new Vacancy();
	if (vacancyModel.getId() != null) {
	    vacancy.setId(vacancyModel.getId());
	}
	vacancy.setName(vacancyModel.getName());
	vacancy.setAmount(vacancyModel.getAmount());
	Position position = positionDAO.getByCriteria(
		Restrictions.like("name", vacancyModel.getPositionName())).get(
		0);
	vacancy.setPosition(position);
	SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	try {
	    vacancy.setStartDate(simpleDateFormat1.parse(vacancyModel
		    .getStartDate()));
	    vacancy.setEndDate(simpleDateFormat1.parse(vacancyModel
		    .getEndDate()));
	} catch (ParseException e) {
	}
	vacancy.setStatus("Waiting");
	if (vacancyModel.getDescription() == null
		|| vacancyModel.getDescription().equals("")) {
	    vacancy.setDescription("None");
	} else {
	    vacancy.setDescription(vacancyModel.getDescription());
	}
	SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss");
	if (vacancyModel.getCreateDate() == null) {
	    vacancy.setCreateDate(new Date());
	} else {
	    try {
		vacancy.setCreateDate(simpleDateFormat2.parse(vacancyModel
			.getCreateDate()));
	    } catch (ParseException e) {
	    }
	}
	vacancy.setLastUpdate(new Date());
	return vacancy;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#toModel(com.nthrms.pojo.Vacancy)
     */
    public VacancyModel toModel(Vacancy vacancy) {
	VacancyModel vacancyModel = new VacancyModel();
	vacancyModel.setId(vacancy.getId());
	vacancyModel.setName(vacancy.getName());
	vacancyModel.setAmount(vacancy.getAmount());
	vacancyModel.setPositionId(vacancy.getPosition().getId());
	vacancyModel.setPositionName(vacancy.getPosition().getName());
	SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	vacancyModel.setStartDate(simpleDateFormat1.format(vacancy
		.getStartDate()));
	vacancyModel.setEndDate(simpleDateFormat1.format(vacancy.getEndDate()));
	vacancyModel.setStatus(vacancy.getStatus());
	vacancyModel.setDescription(vacancy.getDescription());
	SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss");
	vacancyModel.setCreateDate(simpleDateFormat2.format(vacancy
		.getCreateDate()));
	vacancyModel.setLastUpdate(simpleDateFormat2.format(vacancy
		.getLastUpdate()));
	return vacancyModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#countByName(java.lang.String)
     */
    @Transactional(readOnly = true)
    public int countByName(String name) {
	List<Vacancy> vacancyList = vacancyDAO.getByCriteria(Restrictions.like(
		"name", name));
	return vacancyList.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#getIdByName(java.lang.String)
     */
    @Transactional(readOnly = true)
    public int getIdByName(String name) {
	List<Vacancy> vacancyList = vacancyDAO.getByCriteria(Restrictions.like(
		"name", name));
	return vacancyList.get(0).getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.VacancyService#create(com.nthrms.model.VacancyModel)
     */
    @Transactional(readOnly = false)
    public void create(VacancyModel vacancyModel) {
	Vacancy vacancy = toPojo(vacancyModel);
	vacancyDAO.saveOrUpdate(vacancy);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#getByID(java.lang.Integer)
     */
    @Transactional(readOnly = true)
    public VacancyModel getById(Integer id) {
	Vacancy vacancy = vacancyDAO.getById(id.toString());
	VacancyModel vacancyModel = toModel(vacancy);
	return vacancyModel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#status(java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public boolean status(Integer id) {
	Vacancy vacancy = vacancyDAO.getById(id.toString());
	if (vacancy.getStatus().equals("Waiting")) {
	    vacancy.setStatus("Actived");
	    vacancy.setLastUpdate(new Date());
	    vacancyDAO.saveOrUpdate(vacancy);
	    return true;
	} else {
	    return false;
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#search(com.nthrms.pojo.Vacancy)
     */
    @Transactional(readOnly = true)
    public List<VacancyModel> search(VacancyModel vacancyModel) {
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name",
		"%" + vacancyModel.getName() + "%");
	criterionList.add(criterion1);
	if (!vacancyModel.getPositionName().equals("Choose a position")) {
	    Position position = positionDAO.getByCriteria(
		    Restrictions.like("name", vacancyModel.getPositionName()))
		    .get(0);
	    Criterion criterion3 = Restrictions.like("position", position);
	    criterionList.add(criterion3);
	}
	if (!vacancyModel.getStatus().equals("Choose a status")) {
	    Criterion criterion4 = Restrictions.like("status",
		    vacancyModel.getStatus());
	    criterionList.add(criterion4);
	}
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	if (!vacancyModel.getCreateDate().equals("")) {
	    Criterion criterion5 = null;
	    try {
		criterion5 = Restrictions.ge("createDate",
			simpleDateFormat.parse(vacancyModel.getCreateDate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion5);
	}
	if (!vacancyModel.getLastUpdate().equals("")) {
	    Criterion criterion6 = null;
	    try {
		criterion6 = Restrictions.ge("lastUpdate",
			simpleDateFormat.parse(vacancyModel.getLastUpdate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion6);
	}
	if (!vacancyModel.getStartDate().equals("")) {
	    Criterion criterion7 = null;
	    try {
		criterion7 = Restrictions.ge("startDate",
			simpleDateFormat.parse(vacancyModel.getStartDate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion7);
	}
	if (!vacancyModel.getEndDate().equals("")) {
	    Criterion criterion8 = null;
	    try {
		criterion8 = Restrictions.ge("endDate",
			simpleDateFormat.parse(vacancyModel.getEndDate()));
	    } catch (ParseException e) {
	    }
	    criterionList.add(criterion8);
	}
	List<Vacancy> vacancyList = vacancyDAO.getByCriteria(criterionList);
	List<VacancyModel> vacancyModelList = new ArrayList<VacancyModel>();
	for (Vacancy item : vacancyList) {
	    vacancyModelList.add(toModel(item));
	}
	return vacancyModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#delete(java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void delete(Integer id) {
	Vacancy vacancy = vacancyDAO.getById(id.toString());
	List<Phase> phaseList = phaseDAO.getByCriteria(Restrictions.like(
		"vacancy", vacancy));
	for (Phase phase : phaseList) {
	    List<Phasedetail> phaseDetailList = phaseDetailDAO
		    .getByCriteria(Restrictions.like("phase", phase));
	    for (Phasedetail phaseDetail : phaseDetailList) {
		phaseDetailDAO.delete(phaseDetail);
	    }
	    phaseDAO.delete(phase);
	}
	vacancyDAO.delete(vacancy);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#createPhase(java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void createPhase(Integer id) {
	Vacancy vacancy = vacancyDAO.getById(id.toString());
	Phase review = new Phase();
	review.setName("Review");
	review.setVacancy(vacancy);
	review.setTotal(0);
	review.setWaiting(0);
	review.setPass(0);
	review.setReject(0);
	Phase entranceTest = new Phase();
	entranceTest.setName("Entrance test");
	entranceTest.setVacancy(vacancy);
	entranceTest.setTotal(0);
	entranceTest.setWaiting(0);
	entranceTest.setPass(0);
	entranceTest.setReject(0);
	Phase interview = new Phase();
	interview.setName("Interview");
	interview.setVacancy(vacancy);
	interview.setTotal(0);
	interview.setWaiting(0);
	interview.setPass(0);
	interview.setReject(0);
	Phase offer = new Phase();
	offer.setName("Offer");
	offer.setVacancy(vacancy);
	offer.setTotal(0);
	offer.setWaiting(0);
	offer.setPass(0);
	offer.setReject(0);
	Phase hire = new Phase();
	hire.setName("Hire");
	hire.setVacancy(vacancy);
	hire.setTotal(0);
	hire.setWaiting(0);
	hire.setPass(0);
	hire.setReject(0);
	phaseDAO.saveOrUpdate(review);
	phaseDAO.saveOrUpdate(entranceTest);
	phaseDAO.saveOrUpdate(interview);
	phaseDAO.saveOrUpdate(offer);
	phaseDAO.saveOrUpdate(hire);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#getPhase(java.lang.Integer)
     */
    @Transactional(readOnly = true)
    public List<Phase> getPhase(Integer id) {
	Vacancy vacancy = vacancyDAO.getById(id.toString());
	List<Phase> phaseList = phaseDAO.getByCriteria(Restrictions.like(
		"vacancy", vacancy));
	return phaseList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#filter(java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void filter(Integer id) {
	Integer index = 0;
	Integer countNeededSkill = 0;
	Integer countHadSkill = 0;
	Integer ratio = 0;
	Vacancy vacancy = vacancyDAO.getById(id.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Review");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phase = phaseDAO.getByCriteria(criterionList).get(0);
	Position position = vacancy.getPosition();
	List<SkillModel> positionSkillModelList = skillService
		.getAllSkillOfPosition(position.getId());
	List<Candidate> candidateList = candidateDAO.getByCriteria(Restrictions
		.like("status", "Actived"));
	for (Candidate candidate : candidateList) {
	    List<SkillModel> candidateSkillModelList = skillService
		    .getAllSkillOfCandidate(candidate.getId());
	    for (index = 0; index < positionSkillModelList.size(); index++) {
		if (positionSkillModelList.get(index).getLevel() > 1) {
		    countNeededSkill++;
		    if (candidateSkillModelList.get(index).getLevel() >= positionSkillModelList
			    .get(index).getLevel()) {
			countHadSkill++;
		    }
		}
	    }
	    ratio = (countHadSkill / countNeededSkill) * 100;
	    if (ratio < 25) {
		candidateList.remove(index);
	    }
	}
	if (candidateList.size() > 0) {
	    phase.setTotal(candidateList.size());
	    phase.setWaiting(candidateList.size());
	    phaseDAO.saveOrUpdate(phase);
	    for (Candidate candidate : candidateList) {
		candidate.setStatus("In vacancy");
		candidateDAO.saveOrUpdate(candidate);
		Phasedetail phaseDetail = new Phasedetail();
		phaseDetail.setPhase(phase);
		phaseDetail.setCandidate(candidate);
		phaseDetailDAO.saveOrUpdate(phaseDetail);
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.VacancyService#getCandidateInPhase(java.lang.Integer,
     * java.lang.String)
     */
    @Transactional(readOnly = true)
    public List<CandidateModel> getCandidateInPhase(Integer id, String name) {
	Vacancy vacancy = vacancyDAO.getById(id.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", name);
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phase = phaseDAO.getByCriteria(criterionList).get(0);
	List<Phasedetail> phaseDetailList = phaseDetailDAO
		.getByCriteria(Restrictions.like("phase", phase));
	List<CandidateModel> candidateModelList = new ArrayList<CandidateModel>();
	for (Phasedetail phaseDetail : phaseDetailList) {
	    candidateModelList.add(candidateService.toModel(phaseDetail
		    .getCandidate()));
	}
	return candidateModelList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#reviewPass(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void reviewPass(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Review");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	criterionList = new ArrayList<Criterion>();
	criterion1 = Restrictions.like("name", "Entrance test");
	criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseEntranceTest = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseReview.setPass(phaseReview.getPass() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseEntranceTest.setTotal(phaseEntranceTest.getTotal() + 1);
	phaseEntranceTest.setWaiting(phaseEntranceTest.getWaiting() + 1);
	phaseDetail.setPhase(phaseEntranceTest);
	phaseDetailDAO.saveOrUpdate(phaseDetail);
	phaseDAO.saveOrUpdate(phaseReview);
	phaseDAO.saveOrUpdate(phaseEntranceTest);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#reviewReject(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void reviewReject(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Review");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseDetailDAO.delete(phaseDetail);
	phaseReview.setReject(phaseReview.getReject() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseDAO.saveOrUpdate(phaseReview);
	candidate.setStatus("Actived");
	candidateDAO.saveOrUpdate(candidate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.VacancyService#entranceTestwPass(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void entranceTestPass(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Entrance test");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	criterionList = new ArrayList<Criterion>();
	criterion1 = Restrictions.like("name", "Interview");
	criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseEntranceTest = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseReview.setPass(phaseReview.getPass() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseEntranceTest.setTotal(phaseEntranceTest.getTotal() + 1);
	phaseEntranceTest.setWaiting(phaseEntranceTest.getWaiting() + 1);
	phaseDetail.setPhase(phaseEntranceTest);
	phaseDetailDAO.saveOrUpdate(phaseDetail);
	phaseDAO.saveOrUpdate(phaseReview);
	phaseDAO.saveOrUpdate(phaseEntranceTest);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.nthrms.service.VacancyService#entranceTestReject(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void entranceTestReject(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Entrance test");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseDetailDAO.delete(phaseDetail);
	phaseReview.setReject(phaseReview.getReject() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseDAO.saveOrUpdate(phaseReview);
	candidate.setStatus("Actived");
	candidateDAO.saveOrUpdate(candidate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#interviewPass(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void interviewPass(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Interview");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	criterionList = new ArrayList<Criterion>();
	criterion1 = Restrictions.like("name", "Offer");
	criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseEntranceTest = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseReview.setPass(phaseReview.getPass() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseEntranceTest.setTotal(phaseEntranceTest.getTotal() + 1);
	phaseEntranceTest.setWaiting(phaseEntranceTest.getWaiting() + 1);
	phaseDetail.setPhase(phaseEntranceTest);
	phaseDetailDAO.saveOrUpdate(phaseDetail);
	phaseDAO.saveOrUpdate(phaseReview);
	phaseDAO.saveOrUpdate(phaseEntranceTest);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#interviewReject(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void interviewReject(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Interview");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseDetailDAO.delete(phaseDetail);
	phaseReview.setReject(phaseReview.getReject() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseDAO.saveOrUpdate(phaseReview);
	candidate.setStatus("Actived");
	candidateDAO.saveOrUpdate(candidate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#offerPass(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void offerPass(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Offer");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	criterionList = new ArrayList<Criterion>();
	criterion1 = Restrictions.like("name", "Hire");
	criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseEntranceTest = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseReview.setPass(phaseReview.getPass() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseEntranceTest.setTotal(phaseEntranceTest.getTotal() + 1);
	phaseEntranceTest.setWaiting(phaseEntranceTest.getWaiting() + 1);
	phaseDetail.setPhase(phaseEntranceTest);
	candidate.setStatus("Hired");
	candidateDAO.saveOrUpdate(candidate);
	phaseDetailDAO.saveOrUpdate(phaseDetail);
	phaseDAO.saveOrUpdate(phaseReview);
	phaseDAO.saveOrUpdate(phaseEntranceTest);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.nthrms.service.VacancyService#offerReject(java.lang.Integer,
     * java.lang.Integer)
     */
    @Transactional(readOnly = false)
    public void offerReject(Integer idV, Integer idC) {
	Vacancy vacancy = vacancyDAO.getById(idV.toString());
	Candidate candidate = candidateDAO.getById(idC.toString());
	List<Criterion> criterionList = new ArrayList<Criterion>();
	Criterion criterion1 = Restrictions.like("name", "Offer");
	Criterion criterion2 = Restrictions.like("vacancy", vacancy);
	criterionList.add(criterion1);
	criterionList.add(criterion2);
	Phase phaseReview = phaseDAO.getByCriteria(criterionList).get(0);
	Phasedetail phaseDetail = phaseDetailDAO.getByCriteria(
		Restrictions.like("candidate", candidate)).get(0);
	phaseDetailDAO.delete(phaseDetail);
	phaseReview.setReject(phaseReview.getReject() + 1);
	phaseReview.setWaiting(phaseReview.getWaiting() - 1);
	phaseDAO.saveOrUpdate(phaseReview);
	candidate.setStatus("Actived");
	candidateDAO.saveOrUpdate(candidate);
    }
}
