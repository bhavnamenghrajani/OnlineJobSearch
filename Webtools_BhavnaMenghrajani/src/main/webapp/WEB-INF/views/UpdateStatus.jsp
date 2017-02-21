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
<title>Update Status</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	var xmlHttp;
	xmlHttp = GetXmlHttpObject();
	var pageNo = 2;

	function GetXmlHttpObject() {
		var xmlHttp = null;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttp;
	}

	function updateStatus(row) {

		globalRow = row.parentElement.parentElement;
		selectedRow = globalRow.cells;

		var applicationID = selectedRow[1].innerHTML;

		var newStatus = selectedRow[6].getElementsByTagName('select')[0].value;

		if (xmlHttp == null) {
			alert("Your browser does not support AJAX!");
			return;

		}
		xmlHttp.open("GET", "ChangeStatus.htm?applicationID=" + applicationID
				+ "&newStatus=" + newStatus + "", true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function stateChanged() {
			if (xmlHttp.readyState == 4) {
				
				
				selectedRow[5].innerHTML = newStatus;
			}
		}
		return false;

	}
</script>
</head>
<body>

	<%@include file="employerheader.jsp"%>


	<div class="container">
		<div class="form-group">
			<table id="myTable" class="table">
				<thead>


					<tr>
						<th>#</th>
						<th>Application ID</th>
						<th>Job ID</th>
						<th>Job Details</th>
						<th>Applicant Details</th>
						<th>Application Status</th>
						<th>Update status</th>
						<th>Action</th>
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
							<td>Applicant ID: ${jobApplication.jobSeeker.userId} <br />
								Applicant name: ${jobApplication.jobSeeker.firstName}
								${jobApplication.jobSeeker.lastName}<br /> <a
								href="CompleteProfile.htm?applicantID=${jobApplication.jobSeeker.userId}">View
									Complete Profile</a>

							</td>

							<td>${jobApplication.currentStatus }</td>
							<td><select class="form-control" id="sel1" name="jobStatus">

									<option value="New">New</option>
									<option value="Under Review">Under Review</option>
									<option value="Under Background">Under Background Scan</option>
									<option value="Interview Scheduled">Interview
										Scheduled</option>
									<option value="Accepted">Accepted</option>
									<option value="Declined">Declined</option>


							</select></td>
							<td><input type="button" value="Update status"
								onclick="javascript:updateStatus(this)" />
						</tr>

					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>