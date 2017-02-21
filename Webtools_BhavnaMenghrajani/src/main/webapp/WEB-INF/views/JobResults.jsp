<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Results</title>
</head>
<body>
<%@include file="JobSeekerHeader.jsp" %>


<div class="container">
<div class="form-group">
  <table id="myTable" class ="table">
  <thead>
  
  
                        <tr>
							<th>#</th>
							
							<th> Job ID </th>
                            <th>Job Details</th>
                            <th>Action</th>
                            
                        </tr></thead>
                        <tbody>
                        <%! int count = 1; %>
                        <c:forEach var="job" items="${jobList}">
                        
                        <tr>
                       
                        <td>	<%= count++ %> </td> 
                        <td>${job.jobID} </td>
                        <td>
                        <b> ${job.organization.organizationName} </b><br/>
                        <u>${job.jobTitle} </u> <br/>
                        <b>Job Role: </b>${job.jobRole}<br/>
                        <b>Job Category:</b> ${job.jobCategory}<br/>
                        <b>Job Description: </b>${job.jobDescription}<br/>
                        <b>Education Level required:</b> ${job.educationLevel}<br/>
                        <b>Minimum Qualification:</b> ${job.minQualification }<br/>
                        <b>Job Location : </b>${job.jobLocation}<br/>
                        <b>Deadline : </b>${job.deadline}<br/>
                        
                        
                        
                        </td>
                        	<td><a href="ApplyJob.htm?jobID=${job.jobID}">Apply</a> </td>
                        </tr>
                       
                        </c:forEach>
						</tbody>

</table>

<a href="ViewinPDF.htm">View in PDF</a>
</div>
</div>
</body>
</html>