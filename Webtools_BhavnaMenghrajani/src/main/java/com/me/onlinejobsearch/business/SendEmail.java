package com.me.onlinejobsearch.business;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.me.onlinejobsearch.pojo.JobApplication;

public class SendEmail {
	public void sendEmail(JobApplication jobApplication) {
		String toUserEmail = jobApplication.getJobSeeker().getEmailAddress();
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("email@domain.com", "password"));
		email.setAuthentication("email@domain.com", "password");
		email.setStartTLSEnabled(true);
		try {
			email.setFrom("fromemail@domain.com");
			email.addTo(toUserEmail);
			email.setSubject("Congratulations!!! You have been selected");
			email.setMsg(
					"Hello,\n This email serves to notify you that you have been selected in our organization.\n Details below: \n Application Id"
							+ jobApplication.getApplicationID() + "\n Role:" + jobApplication.getJob().getJobTitle()
							+ "\n\n Thanks,\n The Recruitment Team \n "
							+ jobApplication.getJob().getOrganization().getOrganizationName());

			email.send();
		} catch (EmailException ex) {
			ex.printStackTrace();

		}

	}

}
