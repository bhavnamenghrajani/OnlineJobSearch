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
import com.me.onlinejobsearch.pojo.AcademicDetails;
import com.me.onlinejobsearch.pojo.JobSeeker;

@Controller
public class AcademicDetailsController {

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;

	@Autowired
	@Qualifier("academicDetailsValidator")
	AcademicDetailsValidator academicDetailsValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(academicDetailsValidator);
		// binder.setV

	}

	@RequestMapping(value = "/EditEducationDetails.htm", method = RequestMethod.GET)
	public ModelAndView editAcademicDetails(@RequestParam("adID") String academicDetailsID,
			HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");
		if (jobSeeker != null) {
			AcademicDetails academicDetails = userDAO.getAcademicDetailsByID(academicDetailsID);

			ModelAndView mv = new ModelAndView();
			mv.addObject("academicDetails", academicDetails);
			mv.setViewName("EditAcademicDetails");
			return mv;
		} else {

			ModelAndView mv = new ModelAndView();

			mv.setViewName("JobSearchMain");
			return mv;
		}
	}

	@RequestMapping(value = "/DeleteEducationDetails.htm", method = RequestMethod.GET)
	public ModelAndView deleteEducationDetails(@RequestParam("adID") String academicDetailsID,
			HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {
			AcademicDetails academicDetails = userDAO.getAcademicDetailsByID(academicDetailsID);
			userDAO.deleteAcademicDetails(academicDetails);

			List list = userDAO.getAcademicDetails(jobSeeker);
			// return list;
			ModelAndView mv = new ModelAndView();
			mv.addObject("academicDetailsList", list);
			mv.setViewName("ViewAcademicDetails");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			// mv.addObject("academicDetailsList", list);
			mv.setViewName("JobSearchMain");
			return mv;

		}
	}

	@RequestMapping(value = "/EditAD.htm", method = RequestMethod.GET)
	public String handlingCode3() {
		return "JobSearchMain";
	}

	@RequestMapping(value = "/EditAD.htm", method = RequestMethod.POST)
	public ModelAndView editADintoDB(@ModelAttribute("academicDetails") AcademicDetails academicDetails,
			BindingResult result, @RequestParam("ID") String ID, HttpServletRequest request) {

		academicDetailsValidator.validate(academicDetails, result);
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("academicDetails", academicDetails);
			mv.setViewName("AcademicDetails");
			return mv;

		}

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		userDAO.editAcademicDetails(Integer.parseInt(ID), academicDetails.getEducationLevel(),
		academicDetails.getFieldOfStudy(), academicDetails.getGpa(), academicDetails.getGraduated(),
		academicDetails.getSchoolAddress(), academicDetails.getSchoolName(), academicDetails.getStartYear(),
		academicDetails.getEndYear());

		List list = userDAO.getAcademicDetails(jobSeeker);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("academicDetailsList", list);
		mv.setViewName("ViewAcademicDetails");
		return mv;

	}

	@RequestMapping(value = "/ViewAcademicDetails.htm", method = RequestMethod.GET)
	public ModelAndView viewAcademicDetails(HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {

			List list = userDAO.getAcademicDetails(jobSeeker);
			ModelAndView mv = new ModelAndView();
			mv.addObject("academicDetailsList", list);
			mv.setViewName("ViewAcademicDetails");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;

		}
	}

	@RequestMapping(value = "/addMoreAcademicDetails.htm", method = RequestMethod.POST)
	public String addAcademicDetails(@ModelAttribute("academicDetails") AcademicDetails academicDetails,
			BindingResult result, HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {
			return "AcademicDetails";
		} else {
			return "JobSearchMain";
		}
	}

	@RequestMapping(value = "/addMoreAcademicDetails.htm", method = RequestMethod.GET)
	public String handlingCode2() {
		return "JobSearchMain";

	}

	@RequestMapping(value = "/addAD.htm", method = RequestMethod.GET)
	public String handlingCode1() {
		return "JobSearchMain";

	}

	@RequestMapping(value = "/addAD.htm", method = RequestMethod.POST)
	public ModelAndView addAcademicDetailstoDB(@ModelAttribute("academicDetails") AcademicDetails academicDetails,
			BindingResult result, HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");
		if (jobSeeker != null) {
			academicDetailsValidator.validate(academicDetails, result);
			if (result.hasErrors()) {
				ModelAndView mv = new ModelAndView();
				mv.addObject("academicDetails", academicDetails);
				mv.setViewName("AcademicDetails");
				return mv;
			}
			userDAO.addAcademicDetails(academicDetails, jobSeeker);
			List list = userDAO.getAcademicDetails(jobSeeker);
			ModelAndView mv = new ModelAndView();
			mv.addObject("academicDetailsList", list);
			mv.setViewName("ViewAcademicDetails");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;
		}
	}

}
