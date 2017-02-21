package com.me.onlinejobsearch.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Organziation")
public class Organization {

	
	@Id
	@GeneratedValue
	@Column(name = "organizationID", unique = true, nullable = false)
	private int organizationID;
	
	@Column(name = "organizationName")
	private String organizationName;
	
	public int getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	@Column(name = "organizationType")
	private String organizationType;
	
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public Organization()
	{
		
		
	}
	public Organization(String orgName, String orgType)
	{
		this.organizationName = orgName;
		this.organizationType = orgType;
		
	}
	
	
}
