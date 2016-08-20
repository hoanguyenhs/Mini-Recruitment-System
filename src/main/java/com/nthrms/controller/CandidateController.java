/**
 * 
 */
package com.nthrms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nthrms.model.CandidateModel;
import com.nthrms.model.CertificateModel;
import com.nthrms.model.ExperienceModel;
import com.nthrms.service.CandidateService;

/**
 * @author Hoa Nguyen
 * 
 */
@Controller
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/candidate/create", method = RequestMethod.GET)
    ModelAndView actionCreate() {
	ModelAndView mav = new ModelAndView("/candidate/create");
	CandidateModel candidateModel = new CandidateModel();
	mav.addObject("candidateModel", candidateModel);
	return mav;
    }

    @RequestMapping(value = "/candidate/create", method = RequestMethod.POST)
    ModelAndView actionCreate(@Valid CandidateModel candidateModel,
	    BindingResult result,
	    @RequestParam("certificateName") String[] certificateName,
	    @RequestParam("certificateSchool") String[] certificateSchool,
	    @RequestParam("certificateScore") String[] certificateScore,
	    @RequestParam("certificateStarDate") String[] certificateStarDate,
	    @RequestParam("certificateEndDate") String[] certificateEndDate,
	    @RequestParam("experienceCompany") String[] experienceCompany,
	    @RequestParam("experiencePosition") String[] experiencePosition,
	    @RequestParam("experienceSalary") String[] experienceSalary,
	    @RequestParam("experienceStarDate") String[] experienceStarDate,
	    @RequestParam("experienceEndDate") String[] experienceEndDate,
	    @RequestParam("skillID") String[] idList,
	    @RequestParam("level") String[] levelList) {
	ModelAndView mav = new ModelAndView("/candidate/create");
	if (result.hasErrors()) {
	    return mav;
	} else {
	    int count = candidateService
		    .countByEmail(candidateModel.getEmail());
	    if (count > 0) {
		result.rejectValue("email", "error.candidateModel",
			"Email is existed");
		return mav;
	    } else if (!candidateService.checkCertificate(certificateName,
		    certificateSchool, certificateScore, certificateStarDate,
		    certificateEndDate)) {
		result.rejectValue("certificate", "error.candidateModel",
			"Please completely aleast one certificate");
		return mav;
	    } else if (!candidateService.checExperience(experienceCompany,
		    experiencePosition, experienceSalary, experienceStarDate,
		    experienceEndDate)) {
		result.rejectValue("experience", "error.candidateModel",
			"Please completely aleast one experience");
		return mav;
	    } else {
		candidateService.create(candidateModel, certificateName,
			certificateSchool, certificateScore,
			certificateStarDate, certificateEndDate,
			experienceCompany, experiencePosition,
			experienceSalary, experienceStarDate,
			experienceEndDate, idList, levelList);
		int id = candidateService.getIdbyEmail(candidateModel
			.getEmail());
		return new ModelAndView("redirect:/candidate/view/" + id);
	    }
	}
    }

    @RequestMapping(value = "/candidate/view/{id}", method = RequestMethod.GET)
    ModelAndView actionView(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/candidate/view");
	CandidateModel candidateModel = candidateService.getById(id);
	List<CertificateModel> certificateModelList = candidateService
		.getAllCertificate(candidateModel);
	List<ExperienceModel> experienceModelList = candidateService
		.getAllExperience(candidateModel);
	mav.addObject("candidateModel", candidateModel);
	mav.addObject("certificateModelList", certificateModelList);
	mav.addObject("experienceModelList", experienceModelList);
	return mav;
    }

    @RequestMapping(value = "/candidate/status/{id}", method = RequestMethod.GET)
    ModelAndView actionStatus(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("redirect:/candidate/view/" + id);
	candidateService.status(id);
	return mav;
    }

    @RequestMapping(value = "/candidate/edit/{id}", method = RequestMethod.GET)
    ModelAndView actionEdit(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/candidate/edit");
	CandidateModel candidateModel = candidateService.getById(id);
	List<CertificateModel> certificateModelList = candidateService
		.getAllCertificate(candidateModel);
	List<ExperienceModel> experienceModelList = candidateService
		.getAllExperience(candidateModel);
	mav.addObject("candidateModel", candidateModel);
	mav.addObject("certificateModelList", certificateModelList);
	mav.addObject("certificateModelListLength", certificateModelList.size());
	mav.addObject("experienceModelList", experienceModelList);
	mav.addObject("experienceModelListLength", experienceModelList.size());
	return mav;
    }

    @RequestMapping(value = "/candidate/edit/{id}", method = RequestMethod.POST)
    ModelAndView actionEdit(@PathVariable Integer id,
	    @Valid CandidateModel candidateModel, BindingResult result,
	    @RequestParam("certificateName") String[] certificateName,
	    @RequestParam("certificateSchool") String[] certificateSchool,
	    @RequestParam("certificateScore") String[] certificateScore,
	    @RequestParam("certificateStarDate") String[] certificateStarDate,
	    @RequestParam("certificateEndDate") String[] certificateEndDate,
	    @RequestParam("experienceCompany") String[] experienceCompany,
	    @RequestParam("experiencePosition") String[] experiencePosition,
	    @RequestParam("experienceSalary") String[] experienceSalary,
	    @RequestParam("experienceStarDate") String[] experienceStarDate,
	    @RequestParam("experienceEndDate") String[] experienceEndDate,
	    @RequestParam("skillID") String[] idList,
	    @RequestParam("level") String[] levelList,
	    @RequestParam("idCandidate") String[] idCandidateList) {
	ModelAndView mav = new ModelAndView("/candidate/edit");
	List<CertificateModel> certificateModelList = candidateService
		.getAllCertificate(candidateModel);
	List<ExperienceModel> experienceModelList = candidateService
		.getAllExperience(candidateModel);
	mav.addObject("certificateModelList", certificateModelList);
	mav.addObject("certificateModelListLength", certificateModelList.size());
	mav.addObject("experienceModelList", experienceModelList);
	mav.addObject("experienceModelListLength", experienceModelList.size());
	if (result.hasErrors()) {
	    return mav;
	} else {
	    int count = candidateService
		    .countByEmail(candidateModel.getEmail());
	    String email = candidateService.getById(id).getEmail();
	    if (count > 0 && !email.equals(candidateModel.getEmail())) {
		result.rejectValue("email", "error.candidateModel",
			"Email is existed");
		return mav;
	    } else if (!candidateService.checkCertificate(certificateName,
		    certificateSchool, certificateScore, certificateStarDate,
		    certificateEndDate)) {
		result.rejectValue("certificate", "error.candidateModel",
			"Please completely aleast one certificate");
		return mav;
	    } else if (!candidateService.checExperience(experienceCompany,
		    experiencePosition, experienceSalary, experienceStarDate,
		    experienceEndDate)) {
		result.rejectValue("experience", "error.candidateModel",
			"Please completely aleast one experience");
		return mav;
	    } else {
		candidateService.edit(candidateModel, certificateName,
			certificateSchool, certificateScore,
			certificateStarDate, certificateEndDate,
			experienceCompany, experiencePosition,
			experienceSalary, experienceStarDate,
			experienceEndDate, idList, levelList, idCandidateList);
		return new ModelAndView("redirect:/candidate/view/" + id);
	    }
	}
    }

    @RequestMapping(value = "/candidate/clone/{id}", method = RequestMethod.GET)
    ModelAndView actionClone(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/candidate/clone");
	CandidateModel candidateModel = candidateService.getById(id);
	List<CertificateModel> certificateModelList = candidateService
		.getAllCertificate(candidateModel);
	List<ExperienceModel> experienceModelList = candidateService
		.getAllExperience(candidateModel);
	mav.addObject("candidateModel", candidateModel);
	mav.addObject("certificateModelList", certificateModelList);
	mav.addObject("certificateModelListLength", certificateModelList.size());
	mav.addObject("experienceModelList", experienceModelList);
	mav.addObject("experienceModelListLength", experienceModelList.size());
	return mav;
    }

    @RequestMapping(value = "/candidate/clone/{id}", method = RequestMethod.POST)
    ModelAndView actionClone(@PathVariable Integer id,
	    @Valid CandidateModel candidateModel, BindingResult result,
	    @RequestParam("certificateName") String[] certificateName,
	    @RequestParam("certificateSchool") String[] certificateSchool,
	    @RequestParam("certificateScore") String[] certificateScore,
	    @RequestParam("certificateStarDate") String[] certificateStarDate,
	    @RequestParam("certificateEndDate") String[] certificateEndDate,
	    @RequestParam("experienceCompany") String[] experienceCompany,
	    @RequestParam("experiencePosition") String[] experiencePosition,
	    @RequestParam("experienceSalary") String[] experienceSalary,
	    @RequestParam("experienceStarDate") String[] experienceStarDate,
	    @RequestParam("experienceEndDate") String[] experienceEndDate,
	    @RequestParam("skillID") String[] idList,
	    @RequestParam("level") String[] levelList) {
	ModelAndView mav = new ModelAndView("/candidate/clone");
	List<CertificateModel> certificateModelList = candidateService
		.getAllCertificate(candidateModel);
	List<ExperienceModel> experienceModelList = candidateService
		.getAllExperience(candidateModel);
	mav.addObject("certificateModelList", certificateModelList);
	mav.addObject("certificateModelListLength", certificateModelList.size());
	mav.addObject("experienceModelList", experienceModelList);
	mav.addObject("experienceModelListLength", experienceModelList.size());
	if (result.hasErrors()) {
	    return mav;
	} else {
	    int count = candidateService
		    .countByEmail(candidateModel.getEmail());
	    if (count > 0) {
		result.rejectValue("email", "error.candidateModel",
			"Email is existed");
		return mav;
	    } else if (!candidateService.checkCertificate(certificateName,
		    certificateSchool, certificateScore, certificateStarDate,
		    certificateEndDate)) {
		result.rejectValue("certificate", "error.candidateModel",
			"Please completely aleast one certificate");
		return mav;
	    } else if (!candidateService.checExperience(experienceCompany,
		    experiencePosition, experienceSalary, experienceStarDate,
		    experienceEndDate)) {
		result.rejectValue("experience", "error.candidateModel",
			"Please completely aleast one experience");
		return mav;
	    } else {
		candidateModel.setId(null);
		candidateService.create(candidateModel, certificateName,
			certificateSchool, certificateScore,
			certificateStarDate, certificateEndDate,
			experienceCompany, experiencePosition,
			experienceSalary, experienceStarDate,
			experienceEndDate, idList, levelList);
		id = candidateService.getIdbyEmail(candidateModel.getEmail());
		return new ModelAndView("redirect:/candidate/view/" + id);
	    }
	}
    }

    @RequestMapping(value = "/candidate/search", method = RequestMethod.GET)
    ModelAndView actionSearch() {
	ModelAndView mav = new ModelAndView("/candidate/search");
	CandidateModel candidateModel = new CandidateModel();
	mav.addObject("candidateModel", candidateModel);
	return mav;
    }

    @RequestMapping(value = "/candidate/search", method = RequestMethod.POST)
    ModelAndView actionSearch(CandidateModel candidateModel,
	    BindingResult result) {
	ModelAndView mav = new ModelAndView("/candidate/search");
	List<CandidateModel> candidateModelList = candidateService
		.search(candidateModel);
	mav.addObject("candidateModelList", candidateModelList);
	mav.addObject("candidateModelListLength", candidateModelList.size());
	return mav;
    }

    @RequestMapping(value = "/candidate/delete/{id}", method = RequestMethod.GET)
    ModelAndView actionDelete(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/candidate/search");
	CandidateModel candidateModel = candidateService.getById(id);
	candidateService.delete(candidateModel);
	mav.addObject("candidateModel", new CandidateModel());
	mav.addObject("message", "Candidate id " + id
		+ " was deleted successfully");
	return mav;
    }

}
