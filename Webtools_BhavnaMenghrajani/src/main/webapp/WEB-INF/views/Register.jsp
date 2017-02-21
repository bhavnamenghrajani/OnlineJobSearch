<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>GetEmployed Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="text/javascript">
  function validate()
  {
	  var firstName =document.getElementsByTagName("input")[0].value;
	  var lastName = document.getElementsByTagName("input")[1].value;
	  var userName = document.getElementsByTagName("input")[2].value;
	  var password = document.getElementsByTagName("input")[3].value;
	  
	  var regex = /^[a-zA-Z]{1,30}$/;
	  
	  if (!firstName.match(regex)|| firstName == null || firstName == "") {
	        alert("Not a valid First Name");
	        return false;
	    }
	  
	  
	  if (!lastName.match(regex)|| lastName == null || lastName == "") {
	        alert("Not a valid Last Name");
	        return false;
	    }
	  
	  if (!userName.match(regex)|| userName == null || userName == "") {
	        alert("Not a valid User Name");
	        return false;
	    }
	  
	  if (!password.match(regex)|| password == null || password == "") {
	        alert("Not a valid Password");
	        return false;
	    }
	  
	  
	  
	  
	  
  }
  
  </script>
  
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
  <div class="col-sm-2 control-label"></div>
      <div class="col-sm-10">
       <h3>  Registration Page </h3>
      </div>
  <form:form action="Register.htm" commandName="user" method="post" class="form-horizontal" >
  
  <div class="form-group">
      
     <label class="col-sm-2 control-label">First Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="first" path="firstName"/><font color="red"><form:errors path="firstName"/></font>
      </div>
     </div>
    <div class="form-group">
      
     <label class="col-sm-2 control-label">Last name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="last" path="lastName"/><font color="red"><form:errors path="lastName"/></font>
      </div>
     </div>
     <div class="form-group">
      
     <label class="col-sm-2 control-label">User Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="userName" path="userName"/><font color="red"><form:errors path="userName"/></font>
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Password:</label>
      <div class="col-sm-10">
        <form:input type="password" class="form-control" id="password" path="password"/><font color="red"><form:errors path="password"/></font>
      </div>
    </div>
      <div class="form-group">
      
     <label class="col-sm-2 control-label">User Type:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="sel1" path="userType">
        <option>JobSeeker</option>
        <option>Employer</option>
        <option>Admin</option>
        
      </form:select>
    
      </div>
   </div>
   <div class="form-group">
   <div class="col-sm-2"></div>
            <div class="container,col-sm-10">
          <input type="submit" class="btn btn-info" value="Submit" onclick="return validate()">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
      </div>
      
  </form:form>
</div>

</body>
</html>