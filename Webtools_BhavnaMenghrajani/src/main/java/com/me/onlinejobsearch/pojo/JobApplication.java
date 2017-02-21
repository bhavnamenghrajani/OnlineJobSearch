package com.me.onlinejobsearch.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JobApplication")
public class JobApplication {
	@Id
	@GeneratedValue
	@Column(name = "applicationID", unique = true, nullable = false)
	private int applicationID;

	@Column(name = "currentStatus")
	private String currentStatus;

	public String getCurrentStatus() {
		return currentStatus;
	}

	public JobApplication() {

	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "jobID")
	private Job job;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private JobSeeker jobSeeker;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobApplication")
	private Set<ApplicationStatus> applicationStatus = new HashSet<ApplicationStatus>();

	public JobApplication(Job job, JobSeeker jobSeeker) {
		this.job = job;
		this.jobSeeker = jobSeeker;

	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Set<ApplicationStatus> getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(Set<ApplicationStatus> applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

}
