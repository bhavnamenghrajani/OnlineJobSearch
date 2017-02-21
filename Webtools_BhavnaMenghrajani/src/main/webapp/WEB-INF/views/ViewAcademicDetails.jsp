<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Academic Details</title>
</head>
<body>
<%@include file="JobSeekerHeader.jsp" %>


<div class="container">
<form action="addMoreAcademicDetails.htm" method="post" class="form-horizontal">
<div class="form-group">
  <table id="myTable" class ="table">
  <thead>
  
  
                        <tr>
							<th>#</th>
							
							<th> Academic Details</th>
                            <th>Action</th>
                            
                        </tr></thead>
                        <tbody>
                        <%! int count = 1; %>
                        <c:forEach var="academicDetails" items="${academicDetailsList}">
                        
                        <tr>
                       
                        <td>	<%= count++ %> </td> 
                        <td> 
                        
                        <b>Education Level:</b> ${academicDetails.educationLevel}<br/>
                        <b>Field of study:</b> ${academicDetails.fieldOfStudy} <br/>
                        <b>GPA: </b>${academicDetails.gpa}<br/>
                       <b>School Name:</b>${academicDetails.schoolName}<br/>
                       <b> School Address:</b> ${academicDetails.schoolAddress}<br/>
                        <b>Start Year:</b> ${academicDetails.startYear}<br>
                       <b> End Year:</b>${academicDetails.endYear}<br/>
                       <b> Graduated:</b> ${academicDetails.graduated}<br/>
                        
                        
                        
                        
                        </td>
                        	
                        	<td><a href="EditEducationDetails.htm?adID=${academicDetails.academicDetailsID }">Edit</a>| <a href="DeleteEducationDetails.htm?adID=${academicDetails.academicDetailsID}">Delete</a></td>
                        </tr>
                       
                        </c:forEach>
                       
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