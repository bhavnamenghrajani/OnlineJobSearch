<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1" id="myTable">
                        <tr>

                            <th>Job Details</th>
                            <th>Action</th>
                            
                        </tr>
                        <c:forEach var="job" items="${jobList}">
                        
                        <tr>
                        	<td>${job.jobTitle} </td>
                        	<td>Apply </td>
                        </tr>
                        </c:forEach>


</table>
</body>
</html>