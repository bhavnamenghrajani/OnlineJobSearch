<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Professional Details</title>

<script type="text/javascript">
function validate()
{
	
	//alert("Hello");




    var orgName = document.getElementsByTagName("input")[1].value;
    var jobTitle = document.getElementsByTagName("input")[2].value;
    var jobDescription = document.getElementsByTagName("input")[3].value;
    var annualPackage = document.getElementsByTagName("input")[4].value;
    var address = document.getElementsByTagName("input")[5].value;
    
    
    var regex = /^[a-zA-Z]{1,30}$/;
    var salary=/^[0-9]{1,7}$/;
    
    if (!orgName.match(regex)) {
        alert("Not a valid Organization Name Level");
        return false;
    }
    if (!jobTitle.match(regex)) {
        alert("Not a valid JobTitle");
        return false;
    }
    
    if (!jobDescription.match(decimal)) {
        alert("Not a valid jobDescription");
        return false;
    }
    if (!annualPackage.match(salary)) {
        alert("Not a valid salary");
        return false;
    }
    
    if (!address.match(regex)) {
        alert("Not a valid address");
        return false;
    }
    if(endYear<startYear)
    	{
    	alert("End Year should be farther than start year");
    	return false;
    	}
    
   
   
    if (!graduated.match(regex)) {
        alert("Not a valid end year value");
        return false;
    }

      
    
    
	}


</script>




</head>
<body>
<%@include file="JobSeekerHeader.jsp" %>
<div class="container">
  <h2>Please update your professional information</h2>
  <form:form class="form-horizontal" commandName="professionalDetails" method="post" action="EditPD.htm" >
   <input type="hidden" name="ID" value="${professionalDetails.professionalDetailsID}"/>
    <div class="form-group">
      
     <label class="col-sm-2 control-label">Organization Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgName" path="organizationName"/>
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Job Title:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="jobTitle" path="jobTitle"/>
      </div>
    
      
     <label class="col-sm-2 control-label">Job Description:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="jobDescription" path="jobDescription"/>
      </div>
    
          
     <label class="col-sm-2 control-label">Annual Package:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="annualPackage" path="annualPackage"/>
      </div>
     <label class="col-sm-2 control-label">Address</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="address" path="address"/>
      </div>
       </div>
     
        
      <div class="container">
          <input type="submit" class="btn btn-info" value="Submit" onclick="return validate()">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
      
  </form:form>
</div>

    
    

</body>
</html>