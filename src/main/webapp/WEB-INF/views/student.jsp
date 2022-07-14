<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page </title>
</head>
<body>
<h1 align="center" style="color:#4169E1">Welcome To 2022 Debate Event</h1>

<h3 align="center"  style="color:#DC143C" > Student List <h3>
<form>
	<table align="center" >
		<tr>
		
			<td ><a href="addStudent?id=-1"><input type="button" style="color:#4169E1" value="Register New Student"  /> </a>
			
	
			
			</td>
	</table>
	
	<table align="center"  style="width:1000px; height:140px ">
		<tr>
		
			<td ><a href="/StudentDebateManagement/logout" 
					class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a>
			
	
			
			</td>
	</table>
	

	${error}

	<table  align ="center" style="width:1000px; height:140px ; border: 1px  ">
		<tr style="color:#C71585" >
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Course</th>
			<th>Country</th>
			<th>Action</th>
		</tr>


		<c:forEach items="${Student}" var="b">
			<tr align ="center">
				<td>${b.id}</td>
				<td>${b.firstname}</td>
				<td>${b.lastname}</td>
				<td>${b.course }</td>
				<td>${b.country}</td>
				
				<td><a href="updateStudent?id=${b.id}">Update |</a>
					<a href="deleteStudent?id=${b.id}" onclick="return confirm('Are you sure you want to delete?')"> Delete</a></td>
				
			</tr>

		</c:forEach>
	</table>
</body>
</html>
