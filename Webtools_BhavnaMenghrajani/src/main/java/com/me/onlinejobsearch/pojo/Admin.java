package com.me.onlinejobsearch.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
@PrimaryKeyJoinColumn(name="userId")
public class Admin extends User{
	
	@Column(name="adminType")
	String adminType;

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	
	public Admin()
	{
		
	}
	
	
	
	public Admin(String firstName, String lastName, String userName, String password,String userType, String adminType)
	{
		
		super(firstName,lastName,userName,password,userType);
		this.adminType = adminType;
	}
}
