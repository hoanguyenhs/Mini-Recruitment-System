/**
 * 
 */
package com.nthrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nthrms.model.CandidateModel;
import com.nthrms.model.CertificateModel;
import com.nthrms.model.ExperienceModel;
import com.nthrms.model.PositionModel;
import com.nthrms.model.SkillModel;
import com.nthrms.model.VacancyModel;
import com.nthrms.pojo.Phase;
import com.nthrms.service.CandidateService;
import com.nthrms.service.PositionService;
import com.nthrms.service.SkillService;
import com.nthrms.service.VacancyService;

/**
 * @author Hoa Nguyen
 * 
 */
@Controller
public class ReportController {

    @Autowired
    private PositionService positionService;
    
    @Autowired
    private CandidateService candidateService;
    
    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/position/export/{id}", method = RequestMethod.GET)
    ModelAndView actionExportPosition(@PathVariable Integer id) {
	PositionModel positionModel = positionService.getById(id);
	List<SkillModel> skillModelList = skillService
		.getAllSkillOfPosition(id);
	ModelAndView mav = new ModelAndView("positionPdfView");
	mav.addObject("positionModel", positionModel);
	mav.addObject("skillModelList", skillModelList);
	return mav;
    }
    
    @RequestMapping(value = "/candidate/export/{id}", method = RequestMethod.GET)
    ModelAndView actionExportCandidate(@PathVariable Integer id) {
	CandidateModel candidateModel = candidateService.getById(id);
	List<SkillModel> skillModelList = skillService
		.getAllSkillOfCandidate(id);
	List<CertificateModel> certificateModelList = candidateService
		.getAllCertificate(candidateModel);
	List<ExperienceModel> experienceModelList = candidateService
		.getAllExperience(candidateModel);
	ModelAndView mav = new ModelAndView("candidatePdfView");
	mav.addObject("candidateModel", candidateModel);
	mav.addObject("skillModelList", skillModelList);
	mav.addObject("certificateModelList", certificateModelList);
	mav.addObject("experienceModelList", experienceModelList);
	return mav;
    }
    
    @RequestMapping(value = "/vacancy/export1/{id}", method = RequestMethod.GET)
    ModelAndView actionExportVacancy1(@PathVariable Integer id) {
	VacancyModel vacancyModel = vacancyService.getById(id);
	List<Phase> phaseList = vacancyService.getPhase(id);
	ModelAndView mav = new ModelAndView("vacancyPdfView");
	mav.addObject("vacancyModel", vacancyModel);
	mav.addObject("phaseList", phaseList);
	return mav;
    }
    
    @RequestMapping(value = "/vacancy/export2/{id}", method = RequestMethod.GET)
    ModelAndView actionExportVacancy2(@PathVariable Integer id) {
	VacancyModel vacancyModel = vacancyService.getById(id);
	List<Phase> phaseList = vacancyService.getPhase(id);
	ModelAndView mav = new ModelAndView("vacancyGraphPdfView");
	mav.addObject("vacancyModel", vacancyModel);
	mav.addObject("phaseList", phaseList);
	return mav;
    }

}
