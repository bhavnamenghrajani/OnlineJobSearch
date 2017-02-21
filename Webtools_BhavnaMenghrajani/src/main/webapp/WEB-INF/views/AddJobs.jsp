<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  <title>Add Jobs</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>
<%@include file="employerheader.jsp" %>


<div class="container">
  <h2>Create New Jobs</h2>
  <form:form action="AddJobs.htm" commandName="job" method="post" class="form-horizontal" >
  <div class="form-group">
    <label class="col-sm-2 control-label">Job Role:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="sel1" path="jobRole">
        <option>Software Engineering</option>
        <option>Accountant</option>
        <option>Graphics Designer</option>
        <option>Architect</option>
        <option>Project Manager</option>
        <option>CEO</option>
        <option>Bank Manager</option>
        
      </form:select>
    
      </div>  
      </div>
    <div class="form-group">
     <label class="col-sm-2 control-label">Job Title</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgType" path="jobTitle"/>
      </div>
      </div>
     
     <div class="form-group">
       <label class="col-sm-2 control-label">Job Category:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="sel1" path="jobCategory">
        <option>Full time</option>
        <option>Part time</option>
        <option>Internship</option>
        <option>Contract</option>
       
      </form:select>
    
      </div> 
      </div>
      
     
 <div class="form-group">
     <label class="col-sm-2 control-label">Job Description</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgType" path="jobDescription"/>
      </div>
      </div>
    
    <div class="form-group">
    <label class="col-sm-2 control-label">Education level required:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="sel1" path="educationLevel">
        <option>PhD</option>
        <option>Master's Degree</option>
        <option>Bachelor's Degree</option>
        <option>High School</option>
       
      </form:select>
    
      </div>
      </div>
      <div class="form-group">
      <label class="col-sm-2 control-label">Minimum qualification</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="sel1" path="minQualification">
        <option>Computer Science</option>
        <option>Information Assurance</option>
        <option>Secuity Advisor</option>
        <option>Master's in Business Administartion</option>
       
      </form:select>
    
      </div>
      </div>
      <div class="form-group">
      
      <label class="col-sm-2 control-label">Job Location</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="sel1" path="jobLocation">
        <option>New York, NY</option>
        <option>Boston, MA</option>
        <option>SFO, CA</option>
        <option>Las Vegas, Nevada</option>
        <option>Los Angeles, CA</option>
       
      </form:select>
    
      </div>
      </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Deadline</label>
      <div class="col-sm-10">
        <form:input type="date" class="form-control" id="orgType" path="deadline" name="datepicker"/>
      </div>
      </div>
      
      <div class="form-group">
     <label class="col-sm-2 control-label">No of vacancies</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgType" path="noOfVacancies" name="vacancies"/>
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
     </form:form>
</div>




</body>
</html>
