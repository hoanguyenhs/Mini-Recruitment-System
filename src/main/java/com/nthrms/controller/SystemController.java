/**
 * 
 */
package com.nthrms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nthrms.model.UserModel;
import com.nthrms.service.SystemService;

/**
 * @author Hoa Nguyen
 * 
 */
@Controller
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    ModelAndView actionLogin(@RequestParam(required = false) boolean error,
	    HttpServletRequest request) {
	HttpSession session = request.getSession();
	ModelAndView mav = new ModelAndView("/system/login");
	if (error) {
	    mav.addObject("message",
		    "The username or password you entered is incorrect.");
	} else if (session.getAttribute("username") != null) {
	    return new ModelAndView("redirect:/");
	}
	return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView actionIndex() {
	ModelAndView mav = new ModelAndView("redirect:/candidate/search");
	return mav;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    ModelAndView actionError() {
	return new ModelAndView("/system/error");
    }

    @RequestMapping(value = "/system/change-password", method = RequestMethod.GET)
    ModelAndView actionChangePassword() {
	ModelAndView mav = new ModelAndView("/system/change-password");
	mav.addObject("userModel", new UserModel());
	return mav;
    }

    @RequestMapping(value = "system/change-password", method = RequestMethod.POST)
    ModelAndView actionChangePassword(@Valid UserModel userModel,
	    BindingResult result, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("/system/change-password");
	if (result.hasErrors()) {
	    return mav;
	} else {
	    HttpSession session = request.getSession();
	    if (systemService.checkUserNewPassword(userModel,
		    (String) session.getAttribute("username"))) {
		result.rejectValue("oldPassword", "error.userModel",
			"Old password is incorect, please enter valid old passowrd.");
		return mav;
	    }
	    userModel.setPassword(userModel.getNewPassword());
	    if (systemService.updateUserPassword(userModel)) {
		mav.addObject("message",
			"Your password was successfully changed");
	    }
	    return mav;
	}
    }

}
