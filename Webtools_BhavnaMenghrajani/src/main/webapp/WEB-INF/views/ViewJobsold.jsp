<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="JobSeekerHeader.jsp" %>

   Professional Details
    
    
<div class="container">
  <h2>Please update your professional information</h2>
  <form class="form-horizontal" >
    <div class="form-group">
      
     <label class="col-sm-2 control-label">Organization Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="orgName">
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Job Title:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="jobTitle">
      </div>
    
      
     <label class="col-sm-2 control-label">Job Description:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="jobDescription">
      </div>
    
          
     <label class="col-sm-2 control-label">Annual Package:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="annualPackage">
      </div>
     <label class="col-sm-2 control-label">Address</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="address">
      </div>
       </div>
     
        
      <div class="container">
          <input type="submit" class="btn btn-info" value="Submit">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
      
  </form>
</div>

    
    

</body>
</html>