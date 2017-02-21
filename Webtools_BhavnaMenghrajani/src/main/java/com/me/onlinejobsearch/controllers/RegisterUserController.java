package com.me.onlinejobsearch.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.me.onlinejobsearch.dao.UserDAO;
import com.me.onlinejobsearch.pojo.Admin;
import com.me.onlinejobsearch.pojo.Employer;
import com.me.onlinejobsearch.pojo.JobSeeker;
import com.me.onlinejobsearch.pojo.User;


@Controller

public class RegisterUserController {
	
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;

	
	
	@RequestMapping(value = "/Register.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "Register";
	}

	@RequestMapping(value = "/Register.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user) throws Exception {
		
	
		try {
			System.out.print("test");
		//	UserDAO userDao = new UserDAO();
			System.out.print("test1");

			boolean checkUniqueExists = userDao.checkUniqueUserNameExist(user.getUserName());
			
			if(checkUniqueExists)
			{
			userDao.create(user.getUserName(), user.getPassword(),user.getFirstName(), user.getLastName(), user.getUserType());
			return "AddedUser";
			}
			
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		return "UserExists";
		
	}

	
	@RequestMapping(value = "/Profile.htm", method = RequestMethod.GET)
	public ModelAndView profile(HttpServletRequest request) {

		User user = (User)request.getSession().getAttribute("loggedUser");
		
		if(user!=null)
		{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("Profile");
		return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView();

			mv.setViewName("JobSearchMain");
			return mv;
			
		}
	}
	
	
	@RequestMapping(value = "/Profile.htm", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("user") User user, @RequestParam("ID")String userID) {

		System.out.println("User id:"+ userID);
		userDao.updatePersonalInformation(userID, user.getAddressLine1(),user.getAddressLine2(), user.getCity(), user.getCountry(), user.getCountryState(), user.getEmailAddress(), user.getHomeCountryCode(), user.getHomePhone(), user.getOfficeCountryCode(), user.getOfficePhone(), user.getZipCode());
		return "JobSeekerMain";
	}
	
	
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected String authenticate(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) throws Exception {
		
	HttpSession session = request.getSession();	

		try {
			System.out.print("test");
			//UserDAO userDao = new UserDAO();
			
			User enteredUser =userDao.validate(user.getUserName(), user.getPassword(), user.getUserType());
			
			if(enteredUser!= null)
				
			{
				
				if(user.getUserType().equalsIgnoreCase("Employer"))	
				{
					Employer loggedUser =(Employer)enteredUser;
					session.setAttribute("loggedUser", loggedUser);
			
					
					return "EmployerMain";
				}
				else if(user.getUserType().equalsIgnoreCase("JobSeeker"))
				{
					JobSeeker loggedUser =(JobSeeker)enteredUser;
					session.setAttribute("loggedUser", loggedUser);
					return "JobSeekerMain";
				}
				else if(user.getUserType().equalsIgnoreCase("Admin"))
				{
					Admin loggedUser =(Admin)enteredUser;
					session.setAttribute("loggedUser", loggedUser);
					return "AdminMain";
				}
			}
			else
				return "InvalidUser";
				
				
			
			
			

			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "InvalidUser";
	}
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	protected String authenticateForm(@ModelAttribute("user") User user, BindingResult result) throws Exception {
		
		

		

		return "login";
	}

	
	
}
