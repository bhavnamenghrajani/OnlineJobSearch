<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Professional Details</title>
</head>
<body>
<%@include file="JobSeekerHeader.jsp" %>


<div class="container">
<form action="addMoreProfessionalDetails.htm" method="post" class="form-horizontal">
<div class="form-group">
  <table id="myTable" class ="table">
  <thead>
  
  
                        <tr>
							<th>#</th>
							
							<th> Employment Details</th>
                            <th>Action</th>
                            
                        </tr></thead>
                        <tbody>
                        <%! int count = 1; %>
                        <c:forEach var="professionalDetails" items="${professionalDetailsList}">
                        
                        <tr>
                       
                        <td>	<%= count++ %> </td> 
                        <td> 
                        
                       <b> Organization Name:</b> ${professionalDetails.organizationName}<br/>
                       <b> Job Title: </b>${professionalDetails.jobTitle}<br/>
                       <b> Job Description: </b>${professionalDetails.jobDescription}<br/>
                        <b>Annual Package:</b>${professionalDetails.annualPackage}<br/>
                       <b> Address:</b> ${professionalDetails.address}<br/>
                        </td>
                        	
                        	<td><a href="EditJob.htm?pdID=${professionalDetails.professionalDetailsID }">Edit</a>| <a href="DeleteJob.htm?pdID=${professionalDetails.professionalDetailsID}">Delete</a></td>
                        </tr>
                       
                        </c:forEach>
                        <%!  %>
						</tbody>

</table>
</div>
<div class="container">
						<input type="submit" class="btn btn-info" value="Add more">
						</div>
</form>

</div>
</body>
</html>