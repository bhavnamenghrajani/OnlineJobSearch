package com.me.onlinejobsearch.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.onlinejobsearch.pojo.AcademicDetails;
import com.me.onlinejobsearch.pojo.User;

@Component
public class AcademicDetailsValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(AcademicDetails.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "educationLevel", "error.invalid.educationLevel",
				"Education Level Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fieldOfStudy", "error.invalid.fieldofStudy", "fieldOfStudy Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gpa", "error.invalid.gpa", "gpa Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "schoolName", "error.invalid.sname", "schoolName Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "schoolAddress", "error.invalid.saddress", "schoolAddress Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startYear", "error.invalid.startYear", "startYear Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endYear", "error.invalid.endYear", "endYear Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "graduated", "error.invalid.graduated", "This field is Required");
	}
}
