package com.me.onlinejobsearch.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.me.onlinejobsearch.pojo.ApplicationStatus;
import com.me.onlinejobsearch.pojo.Employer;
import com.me.onlinejobsearch.pojo.Job;
import com.me.onlinejobsearch.pojo.JobApplication;
import com.me.onlinejobsearch.pojo.JobSeeker;
import com.me.onlinejobsearch.pojo.Organization;

@Component
public class JobDAO extends DAO{
	
	
	public void create(Job job, Organization org) {
		try {
			begin();
			System.out.println("inside DAO");

			job.setOrganization(org);
			getSession().save(job);

			commit();
			close();
			return;

		} catch (HibernateException e) {
			rollback();

		}
	}
	
	
	public Job getJobByID(String jobID)
	{
		
		int jid= Integer.parseInt(jobID);
		
	        try {
	            begin();
	            Query q = getSession().createQuery("from Job where jobID = :jid");
	            q.setInteger("jid", jid);
	            Job job = (Job) q.uniqueResult();
	            commit();
	            close();
	            return job;
	        } catch (HibernateException e) {
	            rollback();
	           
	        }
	        return null;
		
		
	}

	
	
	public void updateStatus(String applicationID, String newStatus)
	{
		try{
			
			begin();
            Query q = getSession().createQuery("from JobApplication where applicationID = :applicationID");
            q.setInteger("applicationID", Integer.parseInt(applicationID));
            JobApplication jobApplication = (JobApplication) q.uniqueResult();
            
            ApplicationStatus applicationStatus = new ApplicationStatus();
			applicationStatus.setStatus(newStatus);
			applicationStatus.setJobApplication(jobApplication);
			jobApplication.getApplicationStatus().add(applicationStatus);
			jobApplication.setCurrentStatus(newStatus);
			
			getSession().saveOrUpdate(jobApplication);
			getSession().save(applicationStatus);
            
            
            commit();
            close();
            //return job;
			
			
		}
		catch(HibernateException e)
		{
			
			
		}
		
		
	}
	
	public void addJobApplication(String jobID, JobSeeker jobseeker)
	{
		try{
			Job job = getJobByID(jobID);
			begin();
			
			JobApplication jobApp = new JobApplication(job, jobseeker);
			jobApp.setCurrentStatus("New");
			
		//	commit();
			
			ApplicationStatus applicationStatus = new ApplicationStatus();
			applicationStatus.setStatus("New");
			
			
			jobApp.getApplicationStatus().add(applicationStatus);
			getSession().save(jobApp);
			applicationStatus.setJobApplication(jobApp);
			
			getSession().save(applicationStatus);
			
			
			
			
			commit();
			//getSession().update(jobApp);
			//getSession().merge(jobApp);
			//commit();
			close();
			return;
			
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			rollback();
		}
	}
	
	public List<JobApplication> retrieveStatus(JobSeeker jobseeker)
	{
		
		Criteria c = getSession().createCriteria(JobApplication.class);
		Criteria jobSC = c.createCriteria("jobSeeker");
		jobSC.add(Restrictions.eq("userId", jobseeker.getUserId()));
		
		List<JobApplication> list = c.list();
		
		return list;
		
		
	}

	
	public List<JobApplication> retrieveAll(Employer employer)
	{
		Organization organization = employer.getOrganization();
		Criteria c = getSession().createCriteria(JobApplication.class);
		Criteria jobCriteria = c.createCriteria("job");
		Criteria orgCriteria = jobCriteria.createCriteria("organization");
		orgCriteria.add(Restrictions.eq("organizationID", organization.getOrganizationID()));
	//	orgCriteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<JobApplication> list = c.list();
		return list;
		
		
	}
	
	
	
	public List<Job> searchJobs(String jobRole, String jobTitle,String jobCategory, String jobLocation, String orgName)
	{
		
		Criteria c = getSession().createCriteria(Job.class);
		
		if(!jobRole.equalsIgnoreCase("ANY"))
			c.add(Restrictions.ilike("jobRole", jobRole, MatchMode.ANYWHERE));
			
		if(!jobTitle.equalsIgnoreCase(""))
			c.add(Restrictions.ilike("jobTitle",jobTitle, MatchMode.ANYWHERE ));
		
		if(!jobCategory.equalsIgnoreCase("ANY"))
			c.add(Restrictions.ilike("jobCategory", jobCategory, MatchMode.ANYWHERE));
		
		
		if(!jobLocation.equalsIgnoreCase("ANY"))
			c.add(Restrictions.ilike("jobLocation", jobLocation, MatchMode.ANYWHERE));
		
		if(!orgName.equalsIgnoreCase("ANY"))
		{
			Criteria orgCriteria = c.createCriteria("organization");
			orgCriteria.add(Restrictions.eq("organizationName", orgName));
			
		}
		
		List<Job> jobList = c.list();
		
		return jobList;
		
		
	}


	public int checkApplicationExists(JobSeeker jobSeeker, String jobID) {
		// TODO Auto-generated method stub
		
		// organization = employer.getOrganization();
		Criteria c = getSession().createCriteria(JobApplication.class);
		Criteria jobCriteria = c.createCriteria("job");
		Criteria jobSeekerCriteria = c.createCriteria("jobSeeker");
		jobCriteria.add(Restrictions.eq("jobID", Integer.parseInt(jobID)));
		jobSeekerCriteria.add(Restrictions.eq("userId", jobSeeker.getUserId()));
		
	//	orgCriteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		JobApplication jobApplication = (JobApplication)c.uniqueResult();
		
		if(jobApplication!=null)
			return jobApplication.getApplicationID();
		else
			return 0;
		
		
		
	}


	public JobApplication getJobApplicationByID(String applicationID) {
		// TODO Auto-generated method stub
		int aid= Integer.parseInt(applicationID);
		
        try {
            begin();
            Query q = getSession().createQuery("from JobApplication where applicationID = :aid");
            q.setInteger("aid", aid);
            JobApplication jobApplication = (JobApplication) q.uniqueResult();
            commit();
            close();
            return jobApplication;
        } catch (HibernateException e) {
            rollback();
           
        }
        return null;
	}
	
	
	

}
