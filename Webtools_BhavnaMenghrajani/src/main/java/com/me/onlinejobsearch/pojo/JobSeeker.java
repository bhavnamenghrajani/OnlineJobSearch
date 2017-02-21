package com.me.onlinejobsearch.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="JobSeeker")
@PrimaryKeyJoinColumn(name="userId")
public class JobSeeker extends User {
	
	@Column(name="visaStatus")
	private String visaStatus;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobSeeker")
	private Set<ProfessionalDetails> professionalDetails = new HashSet<ProfessionalDetails>();
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobSeeker")
	private Set<AcademicDetails> academicDetails = new HashSet<AcademicDetails>();
	
	public Set<AcademicDetails> getAcademicDetails() {
		return academicDetails;
	}




	public void setAcademicDetails(Set<AcademicDetails> academicDetails) {
		this.academicDetails = academicDetails;
	}




	public Set<ProfessionalDetails> getProfessionalDetails() {
		return professionalDetails;
	}
	
	
	

	public void setProfessionalDetails(Set<ProfessionalDetails> professionalDetails) {
		this.professionalDetails = professionalDetails;
	}

	public String getVisaStatus() {
		return visaStatus;
	}

	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}
	
	public JobSeeker()
	{
		
	}
	
    public JobSeeker(String firstName, String lastName, String userName, String password, String userType,String visaStatus)
    {
    	super(firstName, lastName, userName, password, userType);
		this.visaStatus = visaStatus;
    }

    
    
    
}
