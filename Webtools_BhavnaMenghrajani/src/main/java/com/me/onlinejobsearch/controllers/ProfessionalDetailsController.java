package com.me.onlinejobsearch.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.onlinejobsearch.dao.UserDAO;
import com.me.onlinejobsearch.pojo.JobSeeker;
import com.me.onlinejobsearch.pojo.ProfessionalDetails;

@Controller
public class ProfessionalDetailsController {

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;

	@Autowired
	@Qualifier("professionalDetailsValidator")
	ProfessionalDetailsValidator professionalDetailsValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(professionalDetailsValidator);

	}

	@RequestMapping(value = "/ProfessionalDetails.htm", method = RequestMethod.GET)
	public ModelAndView viewProfessionalDetails(HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {
			List list = userDAO.getProfessionalDetails(jobSeeker);
			ModelAndView mv = new ModelAndView();
			mv.addObject("professionalDetailsList", list);
			mv.setViewName("ViewProfessionalDetails");
			return mv;

		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;

		}

	}

	@RequestMapping(value = "/addMoreProfessionalDetails.htm", method = RequestMethod.GET)
	public String handlerCodeN(@ModelAttribute("professionalDetails") ProfessionalDetails professionalDetails,
			BindingResult result, HttpServletRequest request) {

		return "JobSearchMain";
	}

	@RequestMapping(value = "/addMoreProfessionalDetails.htm", method = RequestMethod.POST)
	public String addMoreProfessionalDetails(
			@ModelAttribute("professionalDetails") ProfessionalDetails professionalDetails, BindingResult result,
			HttpServletRequest request) {

		return "ProfessionalDetails";
	}

	@RequestMapping(value = "/addPD.htm", method = RequestMethod.GET)
	public String addProfessionalDetailstoDB() {
		return "JobSearchMain";

	}

	@RequestMapping(value = "/addPD.htm", method = RequestMethod.POST)
	public ModelAndView addProfessionalDetailstoDB(
			@ModelAttribute("professionalDetails") ProfessionalDetails professionalDetails, BindingResult result,
			HttpServletRequest request) {

		professionalDetailsValidator.validate(professionalDetails, result);
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("professionalDetails", professionalDetails);
			mv.setViewName("ProfessionalDetails");
			return mv;

		}

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");
		userDAO.addProfessionalDetails(professionalDetails, jobSeeker);

		List list = userDAO.getProfessionalDetails(jobSeeker);
		// return list;
		ModelAndView mv = new ModelAndView();
		mv.addObject("professionalDetailsList", list);
		mv.setViewName("ViewProfessionalDetails");
		return mv;

	}

	@RequestMapping(value = "/EditJob.htm", method = RequestMethod.GET)
	public ModelAndView editProfessionalDetails(@RequestParam("pdID") String professionalDetailsID,
			HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");
		if (jobSeeker != null) {
			ProfessionalDetails professionalDetails = userDAO.getProfessionalDetailsByID(professionalDetailsID);
			ModelAndView mv = new ModelAndView();
			mv.addObject("professionalDetails", professionalDetails);
			mv.setViewName("EditProfessionalDetails");
			return mv;
		}

		else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;

		}

	}

	@RequestMapping(value = "/DeleteJob.htm", method = RequestMethod.GET)
	public ModelAndView deleteProfessionalDetails(@RequestParam("pdID") String professionalDetailsID,
			HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");
		if (jobSeeker != null) {

			ProfessionalDetails professionalDetails = userDAO.getProfessionalDetailsByID(professionalDetailsID);
			userDAO.deletePD(professionalDetails);

			List list = userDAO.getProfessionalDetails(jobSeeker);
			// return list;
			ModelAndView mv = new ModelAndView();
			mv.addObject("professionalDetailsList", list);
			mv.setViewName("ViewProfessionalDetails");
			return mv;
		} else {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;
		}

	}

	@RequestMapping(value = "/EditPD.htm", method = RequestMethod.GET)
	public String codeHandler() {
		return "JobSearchMain";

	}

	@RequestMapping(value = "/EditPD.htm", method = RequestMethod.POST)
	public ModelAndView editPDintoDB(@ModelAttribute("professionalDetails") ProfessionalDetails professionalDetails,
			BindingResult result, @RequestParam("ID") String ID, HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");
		if (jobSeeker != null) {
			professionalDetailsValidator.validate(professionalDetails, result);
			if (result.hasErrors()) {
				ModelAndView mv = new ModelAndView();
				mv.addObject("professionalDetails", professionalDetails);
				mv.setViewName("ProfessionalDetails");
				return mv;
			}

			int id = professionalDetails.getProfessionalDetailsID();
			userDAO.editPD(Integer.parseInt(ID), professionalDetails.getAddress(),
			professionalDetails.getAnnualPackage(), professionalDetails.getJobDescription(),
			professionalDetails.getJobTitle(), professionalDetails.getOrganizationName());

			List list = userDAO.getProfessionalDetails(jobSeeker);
			// return list;
			ModelAndView mv = new ModelAndView();
			mv.addObject("professionalDetailsList", list);
			mv.setViewName("ViewProfessionalDetails");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;

		}

	}

}
