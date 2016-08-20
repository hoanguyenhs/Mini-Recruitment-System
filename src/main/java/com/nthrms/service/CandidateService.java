/**
 * 
 */
package com.nthrms.service;

import java.util.List;

import com.nthrms.model.CandidateModel;
import com.nthrms.model.CertificateModel;
import com.nthrms.model.ExperienceModel;
import com.nthrms.pojo.Candidate;

/**
 * @author Hoa Nguyen
 * 
 */
public interface CandidateService {

    Candidate toPojo(CandidateModel candidateModel);

    CandidateModel toModel(Candidate candidate);

    boolean checkCertificate(String[] certificateName,
	    String[] certificateSchool, String[] certificateScore,
	    String[] certificateStarDate, String[] certificateEndDate);

    boolean checExperience(String[] experienceCompany,
	    String[] experiencePosition, String[] experienceSalary,
	    String[] experienceStarDate, String[] experienceEndDate);

    int getIdbyEmail(String email);

    int countByEmail(String email);

    void create(CandidateModel candidateModel, String[] certificateName,
	    String[] certificateSchool, String[] certificateScore,
	    String[] certificateStarDate, String[] certificateEndDate,
	    String[] experienceCompany, String[] experiencePosition,
	    String[] experienceSalary, String[] experienceStarDate,
	    String[] experienceEndDate, String[] idList, String[] levelList);

    CandidateModel getById(Integer id);

    List<CertificateModel> getAllCertificate(CandidateModel candidateModel);

    List<ExperienceModel> getAllExperience(CandidateModel candidateModel);

    void status(Integer id);

    void edit(CandidateModel candidateModel, String[] certificateName,
	    String[] certificateSchool, String[] certificateScore,
	    String[] certificateStarDate, String[] certificateEndDate,
	    String[] experienceCompany, String[] experiencePosition,
	    String[] experienceSalary, String[] experienceStarDate,
	    String[] experienceEndDate, String[] idList, String[] levelList,
	    String[] idCandidateList);

    List<CandidateModel> search(CandidateModel candidateModel);
    
    void delete(CandidateModel candidateModel);
}
