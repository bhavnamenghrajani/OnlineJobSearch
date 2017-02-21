package com.me.onlinejobsearch.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.me.onlinejobsearch.business.CreatePDF;
import com.me.onlinejobsearch.dao.JobDAO;
import com.me.onlinejobsearch.dao.OrganizationDAO;
import com.me.onlinejobsearch.dao.UserDAO;
import com.me.onlinejobsearch.pojo.AcademicDetails;
import com.me.onlinejobsearch.pojo.ApplicationStatus;
import com.me.onlinejobsearch.pojo.Employer;
import com.me.onlinejobsearch.pojo.Job;
import com.me.onlinejobsearch.pojo.JobApplication;
import com.me.onlinejobsearch.pojo.JobSeeker;
import com.me.onlinejobsearch.pojo.ProfessionalDetails;
import com.me.onlinejobsearch.pojo.ProfessionalDetailsContainer;

@Controller
public class JobSeekerController {

	@Autowired
	@Qualifier("orgDAO")
	OrganizationDAO orgDAO;

	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;

	JobSeeker jobSeeker;
	List<Job> jobList;

	@RequestMapping(value = "/ViewJobs.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(HttpServletRequest request) {
		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {
			List orgList = orgDAO.list();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ViewJobs");
			mv.addObject("orgList", orgList);

			return mv;
		} else {
			ModelAndView mv = new ModelAndView();

			mv.setViewName("JobSearchMain");
			return mv;

		}
	}

	@RequestMapping(value = "/ViewJobs.htm", method = RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam("jobRole") String jobRole, @RequestParam("jobTitle") String jobTitle,
			@RequestParam("jobCategory") String jobCategory, @RequestParam("jobLocation") String jobLocation,
			@RequestParam("orgName") String orgName, HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {
			jobList = jobDAO.searchJobs(jobRole, jobTitle, jobCategory, jobLocation, orgName);

			ModelAndView mv = new ModelAndView();
			mv.addObject("jobList", jobList);
			mv.setViewName("JobResults");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();

			mv.setViewName("JobSearchMain");
			return mv;

		}
	}

	@RequestMapping(value = "/ApplyJob.htm", method = RequestMethod.GET)
	public ModelAndView applyJob(@RequestParam("jobID") String jobID, HttpServletRequest request) {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {

			int applicationID = jobDAO.checkApplicationExists(jobSeeker, jobID);

			if (applicationID != 0) {
				ModelAndView mv = new ModelAndView();
				mv.addObject("applicationID", applicationID);
				mv.setViewName("AlreadyApplied");
				return mv;
			} else {
				jobDAO.addJobApplication(jobID, jobSeeker);
				ModelAndView mv = new ModelAndView();
				mv.addObject("jobID", jobID);
				mv.setViewName("JobApplication");
				return mv;
			}
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;
		}
	}

	@RequestMapping(value = "/ApplicationStatus.htm", method = RequestMethod.GET)
	public ModelAndView applicationStatus(HttpServletRequest request) {
		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {
			List<JobApplication> appList = jobDAO.retrieveStatus(jobSeeker);

			ModelAndView mv = new ModelAndView();
			mv.addObject("appList", appList);
			mv.setViewName("ApplicationStatus");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("JobSearchMain");
			return mv;

		}
	}

	@RequestMapping(value = "/ViewinPDF.htm", method = RequestMethod.GET)
	public void viewInPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {

		JobSeeker jobSeeker = (JobSeeker) request.getSession().getAttribute("loggedUser");

		if (jobSeeker != null) {
			ServletContext context = request.getSession().getServletContext();

			CreatePDF createPDF = new CreatePDF();
			createPDF.createPDFDoc(jobList);
			try {
				FileInputStream inputStream = new FileInputStream("D:\\JobListing.pdf");
				String mimeType = context.getMimeType("D:\\JobListing.pdf");
				if (mimeType == null) {

					mimeType = "application/pdf";
				}

				response.setContentType("application/pdf");

				ServletOutputStream outStream = response.getOutputStream();

				byte[] buffer = new byte[1024];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}

				inputStream.close();
				outStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
