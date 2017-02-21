package com.me.onlinejobsearch.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ApplicationStatus")

public class ApplicationStatus {

	@Id
	@GeneratedValue
	@Column(name = "applicationStatusID", unique = true, nullable = false)
	private int applicationStatusID;

	@ManyToOne
	@JoinColumn(name = "jobApplicationID")
	private JobApplication jobApplication;

	@Column(name = "status")
	private String status;

	public int getApplicationStatusID() {
		return applicationStatusID;
	}

	public void setApplicationStatusID(int applicationStatusID) {
		this.applicationStatusID = applicationStatusID;
	}

	public JobApplication getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
