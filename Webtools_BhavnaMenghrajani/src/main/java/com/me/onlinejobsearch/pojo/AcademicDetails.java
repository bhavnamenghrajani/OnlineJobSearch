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
@Table(name = "AcademicDetails")
public class AcademicDetails {

	@Id
	@GeneratedValue
	@Column(name = "academicDetailsID", unique = true, nullable = false)
	int academicDetailsID;

	@Column(name = "educationLevel")
	private String educationLevel; // Master's, Bachelor's

	@Column(name = "fieldOfStudy")
	private String fieldOfStudy;

	@Column(name = "gpa")
	private double gpa;

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public String getGraduated() {
		return graduated;
	}

	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}

	@Column(name = "schoolName")
	private String schoolName;

	@Column(name = "schoolAddress")
	private String schoolAddress;

	@Column(name = "schoolYear")
	private int startYear;

	@Column(name = "endYear")
	private int endYear;

	@Column(name = "graduated")
	private String graduated;

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobSeeker", nullable = false)
	JobSeeker jobSeeker;

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public int getAcademicDetailsID() {
		return academicDetailsID;
	}

	public void setAcademicDetailsID(int academicDetailsID) {
		this.academicDetailsID = academicDetailsID;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
