<%-- 
    Document   : header
    Created on : Apr 1, 2016, 11:28:39 PM
    Author     : Bhavna Menghrajani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>GetEmployed Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">GetEmployed Website</a>
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a href="#">Home</a></li>
    
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">View Profile <span class="caret"></span></a>
        
        
        
        <ul class="dropdown-menu">
          <li><a href="#">Personal Details</a></li>
          <li><a href="#">Academic Details</a></li>
          <li><a href="#">Professional Details</a></li>
        </ul>
        
        
        </li>
      <li><a href="/WEB-INF/jsp/index.jsp">Search Jobs</a></li>
      <li><a href="#">Application Status</a></li> 
      <li><a href="#">Create Portfolio</a></li>
      
        
     
    </ul>
   
    <ul class="nav navbar-nav navbar-right">
      
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
     </div>
  
</nav>
  


</body>
</html>

