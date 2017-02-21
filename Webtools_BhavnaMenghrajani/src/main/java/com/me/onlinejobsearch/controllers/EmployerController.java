package com.me.onlinejobsearch.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.onlinejobsearch.business.SendEmail;
import com.me.onlinejobsearch.dao.EmployerDAO;
import com.me.onlinejobsearch.dao.JobDAO;
import com.me.onlinejobsearch.dao.OrganizationDAO;
import com.me.onlinejobsearch.dao.UserDAO;
import com.me.onlinejobsearch.pojo.Employer;
import com.me.onlinejobsearch.pojo.Job;
import com.me.onlinejobsearch.pojo.JobApplication;
import com.me.onlinejobsearch.pojo.JobSeeker;
import com.me.onlinejobsearch.pojo.Organization;


@Controller
public class EmployerController {
	
	
	@Autowired
	@Qualifier("orgDAO")
	OrganizationDAO orgDAO;
	
	@Autowired
	@Qualifier("empDAO")
	EmployerDAO empDAO;
	
	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	
	Employer employer;
	
	@ModelAttribute("employer")
	public Employer populateEmployer(HttpServletRequest request)
	{
		employer = (Employer)request.getSession().getAttribute("loggedUser");
		return employer;
	}

	
	@RequestMapping(value = "/EmployerProfile.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("employer") Employer employer){
		if(employer!= null)
		{
		List orgList = orgDAO.list();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployerProfile");
		mv.addObject("orgList", orgList);
		
		return mv;}
		else
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			//mv.addObject("orgList", orgList);
			return mv;
		}
	}
	
	
	
	@RequestMapping(value = "/EmployerProfile.htm", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("employer") Employer employer){
		
		String orgName = employer.getOrgName();
		if(!orgName.equals(""))
		{	Organization org = orgDAO.get(orgName);
			employer.setOrganization(org);
		}
		empDAO.updateEmployerProfile(employer);
		return "ProfileSaved";
	}
	
	@RequestMapping(value = "/AddJobs.htm", method = RequestMethod.GET)
	public String submitAddJobsForm(@ModelAttribute("job") Job job){
		
		
		return "AddJobs";
	}
	
	
	@RequestMapping(value = "/AddJobs.htm", method = RequestMethod.POST)
	public String AddJobsForm(@ModelAttribute("job") Job job){
		
		
		//get emp's org
		Organization org = empDAO.getOrganization(employer);
		
		jobDAO.create(job, org);
		
		//ModelAndView mv = new ModelAndView();
		
		return "JobAdded";
	}
	
	@RequestMapping(value = "/CompleteProfile.htm", method = RequestMethod.GET)
	public ModelAndView viewCompleteProfile(@RequestParam("applicantID") String applicantID){
		
		System.out.println("Profile to view "+applicantID);
		JobSeeker jobSeeker = userDAO.getJobSeekerFromID(applicantID); 
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("jobSeeker", jobSeeker);
		mv.setViewName("CompleteProfile");
		return mv;
	}
	
	
	
	
	@RequestMapping(value = "/UpdateStatus.htm", method = RequestMethod.GET)
	public ModelAndView updateStatusPage(HttpServletRequest request)
	{
		
		
		
		Employer employer = (Employer)request.getSession().getAttribute("loggedUser");
		ModelAndView mv = new ModelAndView();
		if(employer!=null)
		{
			List<JobApplication> appList = jobDAO.retrieveAll(employer);
		
		
		System.out.println("List size: "+appList.size());
		
		mv.addObject("appList", appList);
		mv.setViewName("UpdateStatus");
		
		}
		else
		{
			mv.setViewName("JobSearchMain");
			
		}
		
		
		return mv;
	}
	
	@RequestMapping(value = "/ChangeStatus.htm", method = RequestMethod.GET)
	public String changeStatus(@RequestParam("applicationID")String applicationID, @RequestParam("newStatus")String newStatus)
	{
		//Employer employer = (Employer)request.getSession().getAttribute("loggedUser");
		//List<JobApplication> appList = jobDAO.retrieveAll(employer);
		
		JobApplication jobApplication = jobDAO.getJobApplicationByID(applicationID);
		
		jobDAO.updateStatus(applicationID,newStatus);
		String emailAddress = jobApplication.getJobSeeker().getEmailAddress();
		System.out.println("Email id is:"+ emailAddress);
		//createPDFandSendEmail
		if(newStatus.equalsIgnoreCase("Accepted") && !jobApplication.getJobSeeker().getEmailAddress().equals(""))
		{
			System.out.println("Sending email");
			SendEmail se = new SendEmail();
			se.sendEmail(jobApplication);
			
		}
		
		return "UpdateStatus";
		/*ModelAndView mv = new ModelAndView();
		mv.addObject("appList", appList);
		mv.setViewName("UpdateStatus");
		return mv;*/
	}
	

}
