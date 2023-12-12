<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/viewStyle.css">
<title>Add a Catch</title>

</head>
<body>
	<div id="header">
		<h1>Add Your Catch </h1>
		<div> 
			<a href="/dashboard" id="dash" >Dashboard </a>
			<a href="/logout" id="logout">Logout</a>
		</div>
	</div>
	<div id="container">
		<div id="addCatch">
			<form:form action="/fishs/new" method="POST" modelAttribute="fishies">
				
				<form:label path="areaCaught">Area Caught: </form:label>
				<form:errors path="areaCaught" class="fail"/>
				<form:input type="text" class="textBox" path="areaCaught"/>
				<br> 
				
				<form:label path="timeOfDay">Time Of Day Caught: </form:label>
				<form:errors path="timeOfDay" class="fail"/>
				<form:input type="text" class="textBox" path="timeOfDay"/>
				
				<br>
				
				<form:label path="description">Description: </form:label>
				<form:errors path="description" class="fail"/>
				<form:textarea id="desc" path="description"/>
				
			
				
				<form:input type="hidden" path="user" value="${user.id}"/>
		
				<form:input type="hidden" path="fish" value="${fish}"/>
		</div>		
				<input type="submit" id="button" value="Share Your Catch">
			</form:form>
		
	</div>
		
</body>
</html>