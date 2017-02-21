package com.me.onlinejobsearch.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Employer")
@PrimaryKeyJoinColumn(name = "userId")
public class Employer extends User {

	@Column(name = "designation")
	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Transient
	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "organizationID")
	private Organization organization;

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Employer() {

	}

	public Employer(String firstName, String lastName, String userName, String password, String userType,
			String designation) {

		super(firstName, lastName, userName, password, userType);
		this.designation = designation;
	}

}
