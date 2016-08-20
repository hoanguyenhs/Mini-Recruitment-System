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
import org.springframework.web.bind.annotation.ResponseBody;

import com.nthrms.service.SkillService;
import com.nthrms.model.SkillModel;

/**
 * @author Hoa Nguyen
 * 
 */
@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/skill/getAll", method = RequestMethod.GET)
    @ResponseBody
    List<SkillModel> actionGetAllSkill() {
	return skillService.getAllSkillModel();
    }

    @RequestMapping(value = "/position/getSkill/{id}", method = RequestMethod.GET)
    @ResponseBody
    List<SkillModel> actionSkillForView1(@PathVariable Integer id) {
	return skillService.getAllSkillOfPosition(id);
    }

    @RequestMapping(value = "/candidate/getSkill/{id}", method = RequestMethod.GET)
    @ResponseBody
    List<SkillModel> actionSkillForView2(@PathVariable Integer id) {
	return skillService.getAllSkillOfCandidate(id);
    }

}
