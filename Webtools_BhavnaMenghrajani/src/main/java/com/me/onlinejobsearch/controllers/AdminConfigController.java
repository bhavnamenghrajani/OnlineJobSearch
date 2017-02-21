package com.me.onlinejobsearch.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.onlinejobsearch.dao.OrganizationDAO;
import com.me.onlinejobsearch.pojo.Admin;
import com.me.onlinejobsearch.pojo.JobSeeker;
import com.me.onlinejobsearch.pojo.Organization;


@Controller
public class AdminConfigController {
	
	@Autowired
	@Qualifier("orgDAO")
	OrganizationDAO orgDAO;
	
	@RequestMapping(value = "/AddOrganization.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("organization") Organization organization, BindingResult result, HttpServletRequest request) {

		
		Admin admin = (Admin) request.getSession().getAttribute("loggedUser");	
		if(admin!=null)
		
		
			return "AddOrganization";
		else
			return "JobSearchMain";
	}
	
	
	@RequestMapping(value = "/AddOrganization.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("organization") Organization organization, BindingResult result) throws Exception {
		
		

		try {
		
		
			orgDAO.create(organization.getOrganizationName(), organization.getOrganizationType());

			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedUser";
	}

}
