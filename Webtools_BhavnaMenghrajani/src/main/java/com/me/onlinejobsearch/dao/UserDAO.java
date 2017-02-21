package com.me.onlinejobsearch.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.me.onlinejobsearch.pojo.AcademicDetails;
import com.me.onlinejobsearch.pojo.Admin;
import com.me.onlinejobsearch.pojo.ApplicationStatus;
import com.me.onlinejobsearch.pojo.Employer;
import com.me.onlinejobsearch.pojo.JobApplication;
import com.me.onlinejobsearch.pojo.JobSeeker;
import com.me.onlinejobsearch.pojo.ProfessionalDetails;
import com.me.onlinejobsearch.pojo.User;

@Component
public class UserDAO extends DAO{
	
	
	
	public List<ProfessionalDetails> getProfessionalDetails(JobSeeker jobSeeker)
	{
try{
			
			begin();
            Query q = getSession().createQuery("from ProfessionalDetails where jobSeeker = :jobSeekerID");
            q.setInteger("jobSeekerID", jobSeeker.getUserId());
            List<ProfessionalDetails> professionalDetailsList = q.list();
            
            
            
            
            commit();
            close();
            //return job;
            return professionalDetailsList;
			
		}
		catch(HibernateException e)
		{
			rollback();
			
		}
		return null;
		
		
	}
	
	
	
	public void addProfessionalDetails(ProfessionalDetails professionalDetails, JobSeeker jobSeeker)
	{
		
			try {
		           begin();
		            System.out.println("inside DAO");
		            
		            professionalDetails.setJobSeeker(jobSeeker);
		    		jobSeeker.getProfessionalDetails().add(professionalDetails);
		    		getSession().save(professionalDetails);
		       	    //getSession().merge(jobSeeker);
		       	    
		            commit();
		        	close();
		        	return;
		            
		       } catch (HibernateException e) {
		    	   e.printStackTrace();
		            rollback();
		           
		        }
		    
			
			
		
		
		
	}
	
	
	
	public User validate(String userName, String password, String userType)
	{
		try {
            begin();
            Query q=getSession().createQuery("from User u where u.userName = :userName and u.password = :password and u.userType = :userType");
         
           q.setString("userName",userName);
           q.setString("password", password);
           q.setString("userType", userType);
            
            User user=(User)q.uniqueResult();
            
         /*   if(user == null)
            	return false;
           */ 
            
           return user;
            
        } catch (HibernateException e) {
            System.out.println("Error occured");
        }
		
		return null;
		
	}
	
	
	
	public void create(String userName, String password,String firstName, String lastName,String userType )
   {
        try {
           begin();
            System.out.println("inside DAO");
       
            if(userType.equalsIgnoreCase("employer"))
            {
            	
            	Employer employer = new Employer(firstName, lastName, userName, password,userType,"CEO");
            	getSession().save(employer);
            	
            	
            }
            else if(userType.equalsIgnoreCase("jobseeker"))
            {
            	JobSeeker jobSeeker = new JobSeeker(firstName, lastName, userName, password,userType,"StudentVisa");
            	getSession().save(jobSeeker);
            	
            	
            	
            }
            else if(userType.equalsIgnoreCase("Admin"))
            {
            	Admin admin = new Admin(firstName, lastName,userName,password,userType,"General");
            	getSession().save(admin);
            	
            }
            commit();
        	close();
        	return;
            
       } catch (HibernateException e) {
            rollback();
           
        }
    }



	public ProfessionalDetails getProfessionalDetailsByID(String professionalDetailsID) {
		// TODO Auto-generated method stub
		try {
            begin();
            Query q=getSession().createQuery("from ProfessionalDetails pd where pd.professionalDetailsID = :professionalDetailsID");
         
            q.setInteger("professionalDetailsID", Integer.parseInt(professionalDetailsID));
           
            
            ProfessionalDetails pd=(ProfessionalDetails)q.uniqueResult();
            
         /*   if(user == null)
            	return false;
           */ 
            
           return pd;
            
        } catch (HibernateException e) {
            System.out.println("Error occured");
        }
		
		return null;
		
		
		
	}



	public void editPD(int professionalDetailsID, String address, String annualPackage, String jobDescription,
			String jobTitle, String organizationName) {
		
		//System.out.println("DAO has:" + professionalDetails.getJobSeeker().getFirstName());
		
		System.out.println("Fetching record"+ professionalDetailsID);
		// TODO Auto-generated method stub
		try {
			
			begin();
            Query q=getSession().createQuery("from ProfessionalDetails pd where pd.professionalDetailsID = :professionalDetailsID");
         
            q.setInteger("professionalDetailsID", professionalDetailsID);
           
            
            ProfessionalDetails databasePD=(ProfessionalDetails)q.uniqueResult();
            
          //  System.out.println("DB has:"+ databasePD.getAddress());
         
			databasePD.setAddress(address);
			databasePD.setAnnualPackage(annualPackage);
			databasePD.setJobDescription(jobDescription);
			databasePD.setJobTitle(jobTitle);
			databasePD.setOrganizationName(organizationName);
	     
	            System.out.println("inside DAO");
	       	   getSession().update(databasePD);
	            commit();
	        	close();
	        	return;
	            
	       } catch (HibernateException e) {
	    	   e.printStackTrace();
	            rollback();
	           
	        }
	    
		
		
	}



	public void deletePD(ProfessionalDetails professionalDetails) {
		// TODO Auto-generated method stub
		
	
		try {
            begin();
           
            getSession().delete(professionalDetails);
            commit();
            close();
            
         /*   if(user == null)
            	return false;
           */ 
            
           
            
        } catch (HibernateException e) {
            System.out.println("Error occured");
        }
		
		
		
	
		
		
		
	}



	public void addAcademicDetails(AcademicDetails academicDetails, JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		
		try {
	           begin();
	          //  System.out.println("inside DAO");
	            
	            academicDetails.setJobSeeker(jobSeeker);
	    		jobSeeker.getAcademicDetails().add(academicDetails);
	    		getSession().save(academicDetails);
	       	   // getSession().merge(jobSeeker);
	       	    
	            commit();
	        	close();
	        	return;
	            
	       } catch (HibernateException e) {
	    	   e.printStackTrace();
	            rollback();
	           
	        }
		
	}



	public List<AcademicDetails> getAcademicDetails(JobSeeker jobSeeker)
	{
try{
			
			begin();
            Query q = getSession().createQuery("from AcademicDetails where jobSeeker = :jobSeekerID");
            q.setInteger("jobSeekerID", jobSeeker.getUserId());
            List<AcademicDetails> academicDetailsList = q.list();
            
            
            
            
            commit();
            close();
            //return job;
            return academicDetailsList;
			
		}
		catch(HibernateException e)
		{
			rollback();
			
		}
		return null;
		
		
	}



	public AcademicDetails getAcademicDetailsByID(String academicDetailsID) {
		// TODO Auto-generated method stub
		
		try {
            begin();
            Query q=getSession().createQuery("from AcademicDetails ad where ad.academicDetailsID = :academicDetailsID");
         
            q.setInteger("academicDetailsID", Integer.parseInt(academicDetailsID));
           
            
            AcademicDetails ad=(AcademicDetails)q.uniqueResult();
            
         /*   if(user == null)
            	return false;
           */ 
            
           return ad;
            
        } catch (HibernateException e) {
            System.out.println("Error occured");
        }
		
		return null;
		
		

		
		
	}



	public void editAcademicDetails(int academicDetailsID, String educationLevel, String fieldOfStudy, double gpa,
			String graduated, String schoolAddress, String schoolName, int startYear, int endYear) {
		// TODO Auto-generated method stub
		
		
try {
			
			begin();
            Query q=getSession().createQuery("from AcademicDetails ad where ad.academicDetailsID = :academicDetailsID");
         
            q.setInteger("academicDetailsID", academicDetailsID);
           
            
            AcademicDetails databasePD=(AcademicDetails)q.uniqueResult();
            
          //  System.out.println("DB has:"+ databasePD.getAddress());
         
			databasePD.setEducationLevel(educationLevel);
			databasePD.setFieldOfStudy(fieldOfStudy);
			databasePD.setEndYear(endYear);
			databasePD.setGpa(gpa);
			databasePD.setGraduated(graduated);
			databasePD.setSchoolAddress(schoolAddress);
			databasePD.setSchoolName(schoolName);
			databasePD.setStartYear(startYear);
	     
	            System.out.println("inside DAO");
	       	   getSession().update(databasePD);
	            commit();
	        	close();
	        	return;
	            
	       } catch (HibernateException e) {
	    	   e.printStackTrace();
	            rollback();
	           
	        }
	    
		
		
		
		
		
		
	}



	public void deleteAcademicDetails(AcademicDetails academicDetails) {
		// TODO Auto-generated method stub
		
		try {
            begin();
           
            getSession().delete(academicDetails);
            commit();
            close();
            
         /*   if(user == null)
            	return false;
           */ 
            
           
            
        } catch (HibernateException e) {
            System.out.println("Error occured");
        }
		
		
		
	}



	public void updatePersonalInformation(User user) {
		// TODO Auto-generated method stub
		
		
		try {
	           begin();
	            System.out.println("inside DAO");
	       	    getSession().saveOrUpdate(user);
	            commit();
	        	close();
	        	return;
	            
	       } catch (HibernateException e) {
	            rollback();
	            e.printStackTrace();
	           
	        }
		
	}



	public void updatePersonalInformation(String userID,String addressLine1, String addressLine2, String city,
			String country, String countryState, String emailAddress, int homeCountryCode,
			int homePhone, int officeCountryCode, int officePhone, int zipCode) {
		// TODO Auto-generated method stub
		
	try{	
		begin();
        Query q=getSession().createQuery("from User u where u.userId = :userID");
     
        q.setInteger("userID", Integer.parseInt(userID));
       
        
        User databasePD=(User)q.uniqueResult();
        
      //  System.out.println("DB has:"+ databasePD.getAddress());
     
		databasePD.setAddressLine1(addressLine1);
		databasePD.setAddressLine2(addressLine2);
		databasePD.setCity(city);
		databasePD.setCountry(country);
		databasePD.setCountryState(countryState);
		databasePD.setEmailAddress(emailAddress);
		databasePD.setHomeCountryCode(homeCountryCode);
		databasePD.setHomePhone(homePhone);
		databasePD.setOfficeCountryCode(officeCountryCode);
		databasePD.setOfficePhone(officePhone);
		databasePD.setZipCode(zipCode);
     
            System.out.println("inside DAO");
       	   getSession().update(databasePD);
            commit();
        	close();
        	return;
            
       } catch (HibernateException e) {
    	   e.printStackTrace();
            rollback();
           
        }
    
	
		
		
		
		
		
		
	}



	public JobSeeker getJobSeekerFromID(String applicantID) {
		// TODO Auto-generated method stub
		
		Criteria c = getSession().createCriteria(JobSeeker.class);
		
		c.add(Restrictions.eq("userId", Integer.parseInt(applicantID)));
		//jobSeekerCriteria.add(Restrictions.eq("userId", jobSeeker.getUserId()));
		
	//	orgCriteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		JobSeeker jobSeeker = (JobSeeker)c.uniqueResult();
		
		return jobSeeker;
		
		
		
	}



	public boolean checkUniqueUserNameExist(String userName) {
		// TODO Auto-generated method stub
		try {
            begin();
            Query q=getSession().createQuery("from User u where u.userName = :userName");
         
           q.setString("userName",userName);
           
            User user=(User)q.uniqueResult();
            
            if(user == null)
            	return true;
            else
            	return false;
            
            
           
            
        } catch (HibernateException e) {
            System.out.println("Error occured");
        }
		
		return false;
	
	}



	
	


	
}

