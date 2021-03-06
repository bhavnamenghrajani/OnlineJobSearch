<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Academic Details</title>
<script type="text/javascript">
function validate()
{
	var eduLevel = document.getElementsByTagName("input")[1].value;
    var fieldOfStudy = document.getElementsByTagName("input")[2].value;
    var gpa = document.getElementsByTagName("input")[3].value;
    var schoolName = document.getElementsByTagName("input")[4].value;
    var schoolAddress = document.getElementsByTagName("input")[5].value;
    var startYear = document.getElementsByTagName("input")[6].value;
    var endYear = document.getElementsByTagName("input")[7].value;
    var graduated = document.getElementsByTagName("input")[8].value;
	//alert(gpa)
    
    var regex = /^[a-zA-Z]{1,30}$/;
    var startYear=/^[0-9]{2,4}$/;
    var decimal=  /^[0-4]\.\d\d$/;
    if (!eduLevel.match(regex)) {
        alert("Not a valid Education Level");
        return false;
    }
    if (!fieldOfStudy.match(regex)) {
        alert("Not a valid Field of Study");
        return false;
    }
    
    if (!gpa.match(decimal)) {
        alert("GPA should be between 0 to 4.0");
        return false;
    }
    if (!schoolName.match(regex)) {
        alert("Not a valid end year value");
        return false;
    }
    if (!schoolAddress.match(regex)) {
        alert("Not a valid end year value");
        return false;
    }
    if (!startYear.match(yearRegex)) {
        alert("Not a valid start year value");
        return false;
    }
    if (!endYear.match(yearRegex)) {
        alert("Not a valid end year value");
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
  <h2>Please update your Academic information</h2>
  <form:form class="form-horizontal" commandName="academicDetails" method="post" action="EditAD.htm" >
   <input type="hidden" name="ID" value="${academicDetails.academicDetailsID}"/>
    <div class="form-group">      
     <label class="col-sm-2 control-label">Education Level</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="eduLevel" path="educationLevel"/>
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Field of study:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="eduStudy" path="fieldOfStudy"/>
      </div>
    
      
     <label class="col-sm-2 control-label">GPA on scale of 4.0:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="gpa" path="gpa"/>
      </div>
    
          
     <label class="col-sm-2 control-label">School Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="schoolName"/>
      </div>
     <label class="col-sm-2 control-label">School Address:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="schoolAddress"/>
      </div>
      
       <label class="col-sm-2 control-label">Start Year:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="startYear"/>
      </div>
      
       <label class="col-sm-2 control-label">End Year:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="endYear"/>
      </div>
      
       <label class="col-sm-2 control-label">Is Graduated:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="graduated"/>
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