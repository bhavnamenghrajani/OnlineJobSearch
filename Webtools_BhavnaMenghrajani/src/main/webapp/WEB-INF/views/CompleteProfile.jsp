<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	//get the category list
	/* com.me.onlinejobsearch.dao.OrganizationDAO orgD = new com.me.onlinejobsearch.dao.OrganizationDAO();
	 java.util.List orgList = orgD.list();
	 pageContext.setAttribute("orgList", orgList);*/
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>View Complete Profile</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<%@include file="employerheader.jsp"%>

	<div class="container">
	<div class="form-group">
		<h2>JobSeeker Profile</h2>


		<div class="form-group">
			<label class="col-sm-2 control-label">Applicant ID:</label>
			<label class="col-sm-10">${jobSeeker.userId}</label>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">First name:</label>
			<label class="col-sm-10">${jobSeeker.firstName}</label>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Last Name:</label>
			<label class="col-sm-10">${jobSeeker.lastName}</label>
		</div>
		
<div class="form-group">
			<label class="col-sm-2 control-label">Address Line 1:</label>
			<label class="col-sm-10">${jobSeeker.addressLine1}</label>
			</div>
			
			<div class="form-group">
			<label class="col-sm-2 control-label">Address Line 2:</label>
			<label class="col-sm-10">${jobSeeker.addressLine2}</label>
			</div>
			
			<div class="form-group">
			<label class="col-sm-2 control-label">Zipcode:</label>
			<label class="col-sm-10">${jobSeeker.zipCode}</label>
			</div>
			
			<div class="form-group">
			<label class="col-sm-2 control-label">City:</label>
			<label class="col-sm-10">${jobSeeker.city}</label>
			</div>
			
			<div class="form-group">
			<label class="col-sm-2 control-label">State:</label>
			<label class="col-sm-10">${jobSeeker.countryState}</label>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Country:</label>
			<label class="col-sm-10">${jobSeeker.country}</label>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">Email:</label>
			<label class="col-sm-10">${jobSeeker.emailAddress}</label>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">Home Country code:</label>
			<label class="col-sm-10">${jobSeeker.homeCountryCode}</label>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">Home Phone:</label>
			<label class="col-sm-10">${jobSeeker.homePhone}</label>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">Office Country code:</label>
			<label class="col-sm-10">${jobSeeker.officeCountryCode}</label>
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">Office Phone:</label>
			<label class="col-sm-10">${jobSeeker.officePhone}</label>
			</div>
			





		

			<table id="academicTable" class="table">
				<thead>


					<tr>
						<th>#</th>
						<th> Education Details </th>
						
					</tr>
				</thead>
				<tbody>
					<%!int count = 1;%>
					<c:forEach var="academics" items="${jobSeeker.academicDetails}">

						<tr>

							<td><%=count++%></td>
							<td>
							
							
							
						<label class="col-sm-2 control-label"><b>	Education Level: </b></label> <label class="col-sm-10">${academics.educationLevel}</label> <br/>
						<label class="col-sm-2 control-label"><b>Field of Study</b></label><label class="col-sm-10">${academics.fieldOfStudy}</label><br/>
						<label class="col-sm-2 control-label"><b>GPA</b></label> <label class="col-sm-10">${academics.gpa}</label><br/>
						<label class="col-sm-2 control-label"><b>Is Graduated?</b></label> <label class="col-sm-10">${academics.graduated}</label><br/>
						<label class="col-sm-2 control-label"><b>School Name</b></label> <label class="col-sm-10">${academics.schoolName}</label><br/>
						<label class="col-sm-2 control-label"><b>School Address</b></label> <label class="col-sm-10">${academics.schoolAddress}</label><br/>
						<label class="col-sm-2 control-label"><b>Start Year</b></label> <label class="col-sm-10">${academics.startYear}</label><br/>
						<label class="col-sm-2 control-label"><b>End Year</b></label> <label class="col-sm-10">${academics.endYear}</label><br/>
						</td>
							
							
						</tr>

					</c:forEach>
				</tbody>

			</table>
			
<table id="professionalDetailsTable" class="table">
				<thead>


					<tr>
						<th>#</th>
						<th> Professional Details </th>
						
					</tr>
				</thead>
				<tbody>
					<%!int count2 = 1;%>
					<c:forEach var="professional" items="${jobSeeker.professionalDetails}">

						<tr>

							<td><%=count2++%></td>
							<td>
							
							
							
						<label class="col-sm-2 control-label"><b>	Organization Name: </b></label> <label class="col-sm-10">${professional.organizationName}</label> <br/>
						<label class="col-sm-2 control-label"><b>Job Title:</b></label><label class="col-sm-10">${professional.jobTitle}</label><br/>
						<label class="col-sm-2 control-label"><b>Job Description:</b></label> <label class="col-sm-10">${professional.jobDescription}</label><br/>
						<label class="col-sm-2 control-label"><b>Annual Package:</b></label> <label class="col-sm-10">${professional.annualPackage}</label><br/>
						<label class="col-sm-2 control-label"><b>Company Address:</b></label> <label class="col-sm-10">${professional.address}</label><br/>
						
						</td>
							
							
						</tr>

					</c:forEach>
				</tbody>

			</table>

			
			
			
			
			
		</div>

	</div>
	
	


</body>
</html>