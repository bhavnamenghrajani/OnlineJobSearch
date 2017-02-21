<%-- 
    Document   : Profile
    Created on : Apr 1, 2016, 11:21:23 PM
    Author     : Bhavna Menghrajani
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>GetEmployed: Profile</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <script type="text/javascript">
function validate()
{
	var firstName = document.getElementsByTagName("input")[1].value;
    var lastName = document.getElementsByTagName("input")[2].value;
    //var emailAddress = document.getElementsByTagName("input")[2].value;
    var addressLine1 = document.getElementsByTagName("input")[4].value;
    var addressLine2 = document.getElementsByTagName("input")[5].value;
    var city = document.getElementsByTagName("input")[6].value;
    var zipCode = document.getElementsByTagName("input")[7].value;
    var countryState = document.getElementsByTagName("input")[8].value;
    var country = document.getElementsByTagName("input")[9].value;
    
    var homeCountryCode = document.getElementsByTagName("input")[10].value;
    var homePhone = document.getElementsByTagName("input")[11].value;
    var officeCountryCode = document.getElementsByTagName("input")[12].value;
    var officePhone = document.getElementsByTagName("input")[13].value;
	
    
	//alert(gpa)
    
    var regex = /^[a-zA-Z]{1,30}$/;
    var addressRegex =/^[a-zA-Z0-9]{1,30}$/;
    var numberReg=/^[0-9]{2,5}$/;
    var decimal=  /^[0-4]\.\d\d$/;
    if (!firstName.match(regex)) {
        alert("Not a valid First name");
        return false;
    }
    if (!lastName.match(regex)) {
        alert("Not a valid last Name");
        return false;
    }
    
    if (!addressLine1.match(addressRegex)) {
        alert("Not a valid addressline");
        return false;
    }
    if (!addressLine2.match(addressRegex)) {
        alert("Not a valid addressline2");
        return false;
    }
    if (!city.match(regex)) {
        alert("Not a valid city");
        return false;
    }
    if (!zipCode.match(numberReg)) {
        alert("Not a valid zipcode");
        return false;
    }
    if (!countryState.match(regex)) {
        alert("Not a valid country code");
        return false;
    }
    if (!country.match(regex)) {
        alert("Not a valid country");
        return false;
    }

    if (!homeCountryCode.match(numberReg)) {
        alert("Not a valid country code");
        return false;
    }
    if (!homePhone.match(numberReg)) {
        alert("Not a valid phone");
        return false;
    }
    if (!officeCountryCode.match(numberReg)) {
        alert("Not a valid country code");
        return false;
    }
    if (!officePhonef.match(numberReg)) {
        alert("Not a valid phone");
        return false;
    }
      
    
    
	}


</script>
  
  
</head>
<body>

    <%@include file="JobSeekerHeader.jsp" %>

    
    
    
<div class="container">
  
  
  
  
  <form:form action="Profile.htm" commandName="user" method="post" class="form-horizontal" >
   <div class="form-group">
	<input type="hidden" name="ID" value="${user.userId}"/>      
     <div class="col-sm-2 control-label"></div>
      <div class="col-sm-10">
       <h3>  Please enter your profile information: </h3>
      </div>
  
  </div>
    <div class="form-group">
      
     <label class="col-sm-2 control-label">First Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="first" path="firstName"/>
        
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Last Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="last" path="lastName"/>
       
      </div>
    </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Email address:</label>
      <div class="col-sm-10">
        <form:input type="email" class="form-control" id="email" path="emailAddress"/>
       
      </div>
    </div>
    
    <div class="form-group">
     <label class="col-sm-2 control-label"><h4>ADDRESS</h4></label>
      <div class="col-sm-10">
        
      </div>
      </div>
    
      <div class="form-group">
          
     <label class="col-sm-2 control-label">Address Line1:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="address1" path="addressLine1"/>
       
      </div>
     <label class="col-sm-2 control-label">Address Line2:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="address2" path="addressLine2"/>
      </div>
      <label class="col-sm-2 control-label">City:</label>
      
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="city" path="city"/>
       
      </div>
      <label class="col-sm-2 control-label">Zipcode</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="zipcode" path="zipCode"/>
       
      </div>
      <label class="col-sm-2 control-label">State:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="state" path="countryState"/>
       
      </div>
      <label class="col-sm-2 control-label">Country</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="country" path="country"/>
       
      </div>
      </div>
    
    
    <div class="form-group">
     <label class="col-sm-2 control-label"><h4>HOME PHONE NUMBER</h4></label>
      <div class="col-sm-10">
        
      </div>
      </div>
    
     
      <div class="form-group">
          
    <label class="col-sm-2 control-label">Country code</label>
    <div class="col-sm-10">
        <form:input type="text" class="form-control" id="countryCode" path="homeCountryCode"/>
       
      </div>
    <label class="col-sm-2 control-label">Phone number</label>
    <div class="col-sm-10">
        <form:input type="text" class="form-control" id="phoneNumber" path="homePhone"/>
       
      </div>
    
    </div>
    <div class="form-group">
     <label class="col-sm-2 control-label"><h4>OFFICE PHONE NUMBER</h4></label>
      <div class="col-sm-10">
        
      </div>
      </div>
    
      <div class="form-group">
          
    <label class="col-sm-2 control-label">Country code</label>
    <div class="col-sm-10">
        <form:input type="text" class="form-control" id="countryCode" path="officeCountryCode"/>
      </div>
    <label class="col-sm-2 control-label">Phone number</label>
    <div class="col-sm-10">
        <form:input type="text" class="form-control" id="phoneNumber" path="officePhone"/>
      </div>
    
    </div>
      
      <div class="container">
          <input type="submit" class="btn btn-info" value="Submit" onclick="return validate();">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
      
  </form:form>
</div>

    
    

</body>
</html>

