package com.me.onlinejobsearch.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ProfessionalDetailsContainer {

	
	private List<ProfessionalDetails> professionalDetailList = new ArrayList<ProfessionalDetails>();
	
	public List<ProfessionalDetails> getProfessionalDetailList() {
		return professionalDetailList;
	}

	public void setProfessionalDetailList(List<ProfessionalDetails> professionalDetailList) {
		this.professionalDetailList = professionalDetailList;
	}

	public ProfessionalDetailsContainer()
	{
		
		
	}
}
