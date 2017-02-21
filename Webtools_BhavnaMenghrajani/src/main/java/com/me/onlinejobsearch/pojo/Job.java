package com.me.onlinejobsearch.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Job")
public class Job {

	
	@Id
	@GeneratedValue
	@Column(name = "jobID", unique = true, nullable = false)
	private int jobID;
	
	public int getJobID() {
		return jobID;
	}


	public void setJobID(int jobID) {
		this.jobID = jobID;
	}


	public String getJobRole() {
		return jobRole;
	}


	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getJobCategory() {
		return jobCategory;
	}


	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getEducationLevel() {
		return educationLevel;
	}


	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}


	public String getMinQualification() {
		return minQualification;
	}


	public void setMinQualification(String minQualification) {
		this.minQualification = minQualification;
	}


	public String getJobLocation() {
		return jobLocation;
	}


	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}


	public String getDeadline() {
		return deadline;
	}


	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	public String getNoOfVacancies() {
		return noOfVacancies;
	}


	public void setNoOfVacancies(String noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}


	@Column(name = "jobRole")
    private String jobRole;
	
	@Column(name = "jobTitle")
    private String jobTitle;
	
	@Column(name = "jobCategory")
    private String jobCategory;
	
	
	@Column(name = "jobDescription")
    private String jobDescription;
    
	@Column(name = "educationLevel")
	private String educationLevel;
	
	@Column(name = "minQualification")
    private String minQualification;
	
	@Column(name = "jobLocation")
    private String jobLocation;
	
	@Column(name = "deadline")
    private String deadline;
	
	@Column(name = "noOfVacancies")
    private String noOfVacancies;

	
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="organizationID")
	 private Organization organization;
	
	
	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	public Job()
	{}
        
	
	public Job(String jobRole, String jobTitle,String category, String jobDescription, String educationLevel, String minQual, String jobLocation,
			String deadline, String noOfVacancies, Organization org)
	{
		this.jobRole = jobRole;
		this.jobTitle = jobTitle;
		this.jobCategory = category;
		this.jobDescription = jobDescription;
		this.educationLevel = educationLevel;
		this.minQualification = minQual;
		this.jobLocation = jobLocation;
		this.deadline = deadline;
		this.noOfVacancies = noOfVacancies;
		this.organization = org;
		
		
	}
	
}
