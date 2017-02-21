package com.me.onlinejobsearch.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Table(name = "ProfessionalDetails")

public class ProfessionalDetails {
	
	@Id
	@GeneratedValue
	@Column(name = "professionalDetailsID", unique = true, nullable = false)
	int professionalDetailsID;
	
	public int getProfessionalDetailsID() {
		return professionalDetailsID;
	}
	public void setProfessionalDetailsID(int professionalDetailsID) {
		this.professionalDetailsID = professionalDetailsID;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getAnnualPackage() {
		return annualPackage;
	}
	public void setAnnualPackage(String annualPackage) {
		this.annualPackage = annualPackage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "organizationName")
	String organizationName;
	
	@Column(name = "jobTitle")
	String jobTitle;
	
	@Column(name = "jobDescription")
	String jobDescription;
	
	@Column(name = "annualPackage")
	String annualPackage;
	
	@Column(name = "address")
	String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="jobSeeker", nullable=false)
    JobSeeker jobSeeker;

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
    

}
