<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Status</title>

</head>
<body>
	<%@include file="JobSeekerHeader.jsp"%>


	<div class="container">
		<div class="form-group">
			<table id="myTable" class="table">
				<thead>


					<tr>
						<th>#</th>
						<th>Application ID</th>
						<th>Job ID</th>
						<th>Job Details</th>
						<th>Application Status</th>
						
					</tr>
				</thead>
				<tbody>
					<%!int count = 1;%>
					<c:forEach var="jobApplication" items="${appList}">

						<tr>

							<td><%=count++%></td>
							<td>${jobApplication.applicationID}
							<td>${jobApplication.job.jobID}</td>
							<td>${jobApplication.job.jobTitle}</td>
							<td>${jobApplication.currentStatus }</td>
													</tr>

					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>