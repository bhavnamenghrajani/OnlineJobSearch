package com.me.onlinejobsearch.controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.onlinejobsearch.pojo.AcademicDetails;
import com.me.onlinejobsearch.pojo.ProfessionalDetails;

public class ProfessionalDetailsValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(ProfessionalDetails.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationName", "error.invalid.organizationName",
				"organizationName Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "error.invalid.jobTitle", "jobTitle Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription", "error.invalid.jobDescription",
				"jobDescription Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annualPackage", "error.invalid.annualPackage",
				"annualPackage Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.saddress", "Address Required");

	}

}
