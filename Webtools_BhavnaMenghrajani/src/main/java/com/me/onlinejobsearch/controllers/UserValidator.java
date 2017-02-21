package com.me.onlinejobsearch.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.onlinejobsearch.pojo.User;

@Component
public class UserValidator implements Validator {

	boolean checkFirstFour;

	public boolean isCheckFirstFour() {
		return checkFirstFour;
	}

	public void setCheckFirstFour(boolean checkFirstFour) {
		this.checkFirstFour = checkFirstFour;
	}

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub

		User user = (User) obj;

		if (checkFirstFour) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.FirstName",
					"First Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.LastName",
					"Last Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.UserName",
					"User Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.Password",
					"Password Required");
		} else {
			if (!checkFirstFour) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "error.invalid.EmailAddress",
						"Email Required");

				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "error.invalid.AddressLine1",
						"Address Line Required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.City", "City Required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryState", "error.invalid.countryState",
						"State Required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.country",
						"Country Required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeCountryCode", "error.invalid.code",
						"Country Code Required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homePhone", "error.invalid.phone",
						"Phone no Required");
			}
			
		}

	}
}
