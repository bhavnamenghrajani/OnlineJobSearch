<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Organization</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <script type="text/javascript">
  function validate()
  {
	  var orgName =document.getElementsByTagName("input")[0].value;
	  var orgType = document.getElementsByTagName("input")[1].value;
	 
	  
	  var regex = /^[a-zA-Z]{1,30}$/;
	  
	  if (!orgName.match(regex)|| orgName == null || orgName == "") {
	        alert("Not a valid Org name");
	        return false;
	    }
	  
	  
	  if (!orgType.match(regex)|| orgType == null || orgType == "") {
	        alert("Not a valid Last Name");
	        return false;
	    }
	  
	  
  }
  
 </script>
  
</head>
<body>
<%@include file="AdminHeader.jsp" %>
    
<div class="container">
  <h2>Please add New Organization</h2>
  <form:form action="AddOrganization.htm" commandName="organization" method="post" class="form-horizontal" >
    <div class="form-group">
      
     <label class="col-sm-2 control-label">Organization Name</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgName" path="organizationName"/>
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Organization Type:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgType" path="organizationType"/>
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