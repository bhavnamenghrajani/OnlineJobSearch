<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>GetEmployed: View Jobs</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<%@include file="JobSeekerHeader.jsp"%>
	
	 <div class="form-group">
	
     <div class="col-sm-4 control-label"></div>
      <div class="col-sm-8">
       <h3>  Search Jobs </h3></br>
      </div>
  
  </div>


	<div class="container">
		
		<form action="ViewJobs.htm" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">Job Role:</label>

				<div class="col-sm-10">

					
					<select class="form-control" id="sel1" name="jobRole">
						<option>ANY</option>
						<option>Software Engineering</option>
						<option>Accountant</option>
						<option>Graphics Designer</option>
						<option>Architect</option>
						<option>Project Manager</option>
						<option>CEO</option>
						<option>Bank Manager</option>

					</select>

				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Job Title</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="jobTitle"
						name="jobTitle" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Job Category:</label>

				<div class="col-sm-10">

					<select class="form-control" id="sel1" name="jobCategory">
						<option>ANY</option>
						<option>Full time</option>
						<option>Part time</option>
						<option>Internship</option>
						<option>Contract</option>

					</select>

				</div>
			</div>




			<div class="form-group">

				<label class="col-sm-2 control-label">Job Location</label>

				<div class="col-sm-10">

					<select class="form-control" id="sel1" name="jobLocation">
						<option>ANY</option>
						<option>New York, NY</option>
						<option>Boston, MA</option>
						<option>SFO, CA</option>
						<option>Las Vegas, Nevada</option>
						<option>Los Angeles, CA</option>

					</select>

				</div>
			</div>

<div class="form-group">
			<label class="col-sm-2 control-label">Organization Name:</label>
			<div class="col-sm-10">
				<select class="form-control" name ="orgName">
					<option>ANY</option>
					<c:forEach var="org" items="${orgList}">
						<option>${org.organizationName}</option>
					</c:forEach>
				</select>
			</div>
</div>


			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="container,col-sm-10">
					<div class="container">
						<input type="submit" class="btn btn-info" value="Submit">
						<input type="reset" class="btn btn-info" value="Refresh">

					</div>
				</div>
			</div>
		</form>
	</div>





</body>
</html>

