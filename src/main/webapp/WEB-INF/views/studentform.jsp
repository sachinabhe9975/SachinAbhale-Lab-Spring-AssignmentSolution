<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color:#4169E1"> Student Debate management</h1>



<form action="save" method="post">
<table align="center" ; >
<h3 align="center" style="color:#FF0000" > Save Student details <h3>
<tr>
<td> First Name</td><td><input type="text" value="${Student.firstname}" name="firstname" required  /> </td></tr>
<tr>
<td> Last Name </td><td><input type="text" value="${Student.lastname}" name="lastname" required /> </td>
</tr>
<tr>
<td> Course</td><td><input type="text" value="${Student.course}" name="course" required /> </td>
</tr>
<tr>
<td> Country </td><td><input type="text" value="${Student.country}" name="country" required/> </td>
</tr>

<tr>
<td colspan="2"><input type="hidden" value='${Student.id}' name="id"/><input type="submit" VALUE="Save"/></td></tr>
</table>>
</form>
<table align="center" >
		<tr>
		
			<td ><a href="list"><input type="button" style="color:#FF0000" value="back to list"  /> </a>
			
			
			</td>
	</table>

</body>
</html>