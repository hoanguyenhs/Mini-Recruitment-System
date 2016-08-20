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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nthrms.model.VacancyModel;
import com.nthrms.service.PositionService;
import com.nthrms.service.VacancyService;

/**
 * @author Hoa Nguyen
 * 
 */
@Controller
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/vacancy/create", method = RequestMethod.GET)
    ModelAndView actionCreate() {
	ModelAndView mav = new ModelAndView("/vacancy/create");
	mav.addObject("vacancyModel", new VacancyModel());
	mav.addObject("positionModelList", positionService.getActivedPosition());
	return mav;
    }

    @RequestMapping(value = "/vacancy/create", method = RequestMethod.POST)
    ModelAndView actionCreate(@Valid VacancyModel vacancyModel,
	    BindingResult result) {
	ModelAndView mav = new ModelAndView("/vacancy/create");
	if (result.hasErrors()) {
	    mav.addObject("positionModelList", positionService.getActivedPosition());
	    return mav;
	} else {
	    int count = vacancyService.countByName(vacancyModel.getName());
	    if (count > 0) {
		result.rejectValue("name", "error.vacancyModel",
			"Vacancy name is existed");
		mav.addObject("positionModelList",
			positionService.getActivedPosition());
		return mav;
	    } else {
		vacancyService.create(vacancyModel);
		int id = vacancyService.getIdByName(vacancyModel.getName());
		vacancyService.createPhase(id);
		return new ModelAndView("redirect:/vacancy/view/" + id);
	    }
	}
    }

    @RequestMapping(value = "/vacancy/edit/{id}", method = RequestMethod.GET)
    ModelAndView actionEdit(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/edit");
	VacancyModel vacancyModel = vacancyService.getById(id);
	mav.addObject("vacancyModel", vacancyModel);
	mav.addObject("positionModelList", positionService.getActivedPosition());
	return mav;
    }

    @RequestMapping(value = "/vacancy/edit/{id}", method = RequestMethod.POST)
    ModelAndView actionEdit(@PathVariable Integer id,
	    @Valid VacancyModel vacancyModel, BindingResult result) {
	ModelAndView mav = new ModelAndView("/vacancy/edit");
	if (result.hasErrors()) {
	    mav.addObject("positionModelList", positionService.getActivedPosition());
	    return mav;
	} else {
	    int count = vacancyService.countByName(vacancyModel.getName());
	    String name = vacancyService.getById(id).getName();
	    if (count > 0 && !name.equals(vacancyModel.getName())) {
		result.rejectValue("name", "error.vacancyModel",
			"Vacancy name is existed");
		mav.addObject("positionModelList",
			positionService.getActivedPosition());
		return mav;
	    } else {
		vacancyService.create(vacancyModel);
		return new ModelAndView("redirect:/vacancy/view/" + id);
	    }
	}
    }

    @RequestMapping(value = "/vacancy/clone/{id}", method = RequestMethod.GET)
    ModelAndView actionClone(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/clone");
	VacancyModel vacancyModel = vacancyService.getById(id);
	mav.addObject("vacancyModel", vacancyModel);
	mav.addObject("positionModelList", positionService.getActivedPosition());
	return mav;
    }

    @RequestMapping(value = "/vacancy/clone/{id}", method = RequestMethod.POST)
    ModelAndView actionClone(@PathVariable Integer id,
	    @Valid VacancyModel vacancyModel, BindingResult result) {
	ModelAndView mav = new ModelAndView("/vacancy/clone");
	if (result.hasErrors()) {
	    mav.addObject("positionModelList", positionService.getActivedPosition());
	    return mav;
	} else {
	    int count = vacancyService.countByName(vacancyModel.getName());
	    if (count > 0) {
		result.rejectValue("name", "error.vacancyModel",
			"Vacancy name is existed");
		mav.addObject("positionModelList",
			positionService.getActivedPosition());
		return mav;
	    } else {
		vacancyModel.setId(null);
		vacancyService.create(vacancyModel);
		id = vacancyService.getIdByName(vacancyModel.getName());
		vacancyService.createPhase(id);
		return new ModelAndView("redirect:/vacancy/view/" + id);
	    }
	}
    }

    @RequestMapping(value = "/vacancy/search", method = RequestMethod.GET)
    ModelAndView actionSearch() {
	ModelAndView mav = new ModelAndView("/vacancy/search");
	mav.addObject("vacancyModel", new VacancyModel());
	mav.addObject("positionModelList", positionService.getActivedPosition());
	return mav;
    }

    @RequestMapping(value = "/vacancy/search", method = RequestMethod.POST)
    ModelAndView actionSearch(VacancyModel vacancyModel, BindingResult result) {
	ModelAndView mav = new ModelAndView("/vacancy/search");
	List<VacancyModel> vacancyModelList = vacancyService
		.search(vacancyModel);
	mav.addObject("vacancyModelList", vacancyModelList);
	mav.addObject("vacancyModelListLength", vacancyModelList.size());
	mav.addObject("positionModelList", positionService.getActivedPosition());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{id}", method = RequestMethod.GET)
    ModelAndView actionView(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/view");
	VacancyModel vacancyModel = vacancyService.getById(id);
	mav.addObject("vacancyModel", vacancyModel);
	mav.addObject("phaseList", vacancyService.getPhase(id));
	return mav;
    }

    @RequestMapping(value = "/vacancy/active/{id}", method = RequestMethod.GET)
    ModelAndView actionStart(@PathVariable Integer id,
	    RedirectAttributes redirectAttributes) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + id);
	if (vacancyService.status(id)) {
	    vacancyService.filter(id);
	    return mav;
	} else {
	    redirectAttributes.addFlashAttribute("message",
		    "This vacancy status is not 'Waiting'");
	    return mav;
	}
    }

    @RequestMapping(value = "/vacancy/view/{id}/review", method = RequestMethod.GET)
    ModelAndView actionReview(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/review");
	mav.addObject("vacancyModel", vacancyService.getById(id));
	mav.addObject("phaseList", vacancyService.getPhase(id));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(id, "Review"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(id, "Review").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{id}/entrancetest", method = RequestMethod.GET)
    ModelAndView actionEntranceTest(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/entrancetest");
	mav.addObject("vacancyModel", vacancyService.getById(id));
	mav.addObject("phaseList", vacancyService.getPhase(id));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(id, "Entrance test"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(id, "Entrance test").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{id}/interview", method = RequestMethod.GET)
    ModelAndView actionInterview(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/interview");
	mav.addObject("vacancyModel", vacancyService.getById(id));
	mav.addObject("phaseList", vacancyService.getPhase(id));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(id, "Interview"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(id, "Interview").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{id}/offer", method = RequestMethod.GET)
    ModelAndView actionOffer(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/offer");
	mav.addObject("vacancyModel", vacancyService.getById(id));
	mav.addObject("phaseList", vacancyService.getPhase(id));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(id, "Offer"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(id, "Offer").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{id}/hire", method = RequestMethod.GET)
    ModelAndView actionHire(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/hire");
	mav.addObject("vacancyModel", vacancyService.getById(id));
	mav.addObject("phaseList", vacancyService.getPhase(id));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(id, "Hire"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(id, "Hire").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/review/{idC}/pass")
    ModelAndView actionReviewPass(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/review");
	vacancyService.reviewPass(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Review"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Review").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/review/{idC}/reject")
    ModelAndView actionReviewReject(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/review");
	vacancyService.reviewReject(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Review"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Review").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/entrancetest/{idC}/pass")
    ModelAndView actionEntranceTestPass(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/entrancetest");
	vacancyService.entranceTestPass(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Entrance test"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Entrance test").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/entrancetest/{idC}/reject")
    ModelAndView actionEntranceTestReject(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/entrancetest");
	vacancyService.entranceTestReject(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Entrance test"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Entrance test").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/interview/{idC}/pass")
    ModelAndView actionInterviewPass(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/interview");
	vacancyService.interviewPass(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Interview"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Interview").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/interview/{idC}/reject")
    ModelAndView actionInterviewReject(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/interview");
	vacancyService.interviewReject(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Interview"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Interview").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/offer/{idC}/pass")
    ModelAndView actionOfferPass(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/offer");
	vacancyService.offerPass(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Offer"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Offer").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/view/{idV}/offer/{idC}/reject")
    ModelAndView actionOfferReject(@PathVariable Integer idV,
	    @PathVariable Integer idC) {
	ModelAndView mav = new ModelAndView("redirect:/vacancy/view/" + idV
		+ "/offer");
	vacancyService.offerReject(idV, idC);
	mav.addObject("vacancyModel", vacancyService.getById(idV));
	mav.addObject("phaseList", vacancyService.getPhase(idV));
	mav.addObject("candidateModelList",
		vacancyService.getCandidateInPhase(idV, "Offer"));
	mav.addObject("candidateModelListLength", vacancyService
		.getCandidateInPhase(idV, "Offer").size());
	return mav;
    }

    @RequestMapping(value = "/vacancy/delete/{id}", method = RequestMethod.GET)
    ModelAndView actionDelete(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/vacancy/search");
	vacancyService.delete(id);
	mav.addObject("vacancyModel", new VacancyModel());
	mav.addObject("message", "Vacancy id " + id
		+ " was deleted successfully");
	return mav;
    }
}
