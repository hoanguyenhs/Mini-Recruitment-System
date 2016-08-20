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

import com.nthrms.model.PositionModel;
import com.nthrms.service.PositionService;
import com.nthrms.service.SkillService;

/**
 * @author Hoa Nguyen
 * 
 */
@Controller
public class PositionController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/position/create", method = RequestMethod.GET)
    ModelAndView actionCreate() {
	ModelAndView mav = new ModelAndView("/position/create");
	mav.addObject("positionModel", new PositionModel());
	return mav;
    }

    @RequestMapping(value = "/position/create", method = RequestMethod.POST)
    ModelAndView actionCreate(@Valid PositionModel positionModel,
	    BindingResult result, @RequestParam("skillID") String[] idList,
	    @RequestParam("level") String[] levelList) {
	ModelAndView mav = new ModelAndView("/position/create");
	PositionModel positionModelDB = positionService.getByName(positionModel
		.getName());
	if (result.hasErrors()) {
	    return mav;
	} else if (!positionModelDB.getName().equals("")) {
	    result.rejectValue("name", "error.positionModel",
		    "Position name is existed");
	    return mav;
	} else {
	    positionService.create(positionModel, idList, levelList);
	    int id = positionService.getByName(positionModel.getName()).getId();
	    return mav = new ModelAndView("redirect:/position/view/" + id);
	}
    }

    @RequestMapping(value = "/position/view/{id}", method = RequestMethod.GET)
    ModelAndView actionView(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/position/view");
	PositionModel positionModel = positionService.getById(id);
	mav.addObject("positionModel", positionModel);
	return mav;
    }

    @RequestMapping(value = "/position/edit/{id}", method = RequestMethod.GET)
    ModelAndView actionEdit(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/position/edit");
	PositionModel positionModel = positionService.getById(id);
	mav.addObject("positionModel", positionModel);
	return mav;
    }

    @RequestMapping(value = "/position/edit/{id}", method = RequestMethod.POST)
    ModelAndView actionEdit(@PathVariable Integer id,
	    @Valid PositionModel positionModel, BindingResult result,
	    @RequestParam("skillID") String[] idList,
	    @RequestParam("level") String[] levelList,
	    @RequestParam("idPosition") String[] idPositionList) {
	ModelAndView mav = new ModelAndView("/position/edit");
	PositionModel positionModelDB = positionService.getByName(positionModel
		.getName());
	PositionModel positionModelCurrent = positionService.getById(id);
	if (result.hasErrors()) {
	    return mav;
	} else if (!positionModelDB.getName().equals("")
		&& !positionModelDB.getName().equals(
			positionModelCurrent.getName())) {
	    result.rejectValue("name", "error.positionModel",
		    "Position name is existed");
	    return mav;
	} else {
	    positionService.edit(positionModel, idList, levelList,
		    idPositionList);
	    return mav = new ModelAndView("redirect:/position/view/" + id);
	}
    }

    @RequestMapping(value = "/position/delete/{id}", method = RequestMethod.GET)
    ModelAndView actionDelete(@PathVariable Integer id) {
	PositionModel positionModel = positionService.getById(id);
	positionService.delete(positionModel);
	ModelAndView mav = new ModelAndView("/position/search");
	mav.addObject("positionModel", new PositionModel());
	mav.addObject("message", "Position id " + id
		+ " was deleted successfully");
	return mav;
    }

    @RequestMapping(value = "/position/clone/{id}", method = RequestMethod.GET)
    ModelAndView actionClone(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("/position/clone");
	PositionModel positionModel = positionService.getById(id);
	mav.addObject("positionModel", positionModel);
	return mav;
    }

    @RequestMapping(value = "/position/clone/{id}", method = RequestMethod.POST)
    ModelAndView actionClone(@PathVariable Integer id,
	    @Valid PositionModel positionModel, BindingResult result,
	    @RequestParam("skillID") String[] idList,
	    @RequestParam("level") String[] levelList) {
	ModelAndView mav = new ModelAndView("/position/clone");
	PositionModel positionModelDB = positionService.getByName(positionModel
		.getName());
	if (result.hasErrors()) {
	    return mav;
	} else if (!positionModelDB.getName().equals("")) {
	    result.rejectValue("name", "error.positionModel",
		    "Position name is existed");
	    return mav;
	} else {
	    positionService.create(positionModel, idList, levelList);
	    id = positionService.getByName(positionModel.getName()).getId();
	    return mav = new ModelAndView("redirect:/position/view/" + id);
	}
    }

    @RequestMapping(value = "position/status/{id}", method = RequestMethod.GET)
    ModelAndView actionStatus(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("redirect:/position/view/" + id);
	positionService.status(id);
	return mav;
    }

    @RequestMapping(value = "/position/search", method = RequestMethod.GET)
    ModelAndView actionSearch() {
	ModelAndView mav = new ModelAndView("/position/search");
	mav.addObject("positionModel", new PositionModel());
	return mav;
    }

    @RequestMapping(value = "/position/search", method = RequestMethod.POST)
    ModelAndView actionSearch(PositionModel positionModel, BindingResult result) {
	ModelAndView mav = new ModelAndView("/position/search");
	List<PositionModel> positionModelList = positionService
		.search(positionModel);
	mav.addObject("positionModelList", positionModelList);
	mav.addObject("positionModelListLength", positionModelList.size());
	return mav;
    }

}
