<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/style.css">
<title>Login Page</title>
</head>
<body>
	
		<h1 id="title">Fish Spot</h1>
		<h2 id="underTitle" >Sign in to share your fish!</h2>
	<div id="page">	
		<div id="register">
		<h2>Register</h2>
		<form:form action="/register" method="post" modelAttribute="newUser">
			
			<label>Username: </label>
			<form:errors path="userName" class="fail"/>
			<form:input class="input" path="userName"/>
			<br> 
			
			<label>Email: </label>
			<form:errors path="email" class="fail"/>
			<form:input class="input" path="email"/>
			<br> 
			
			<label>Password: </label>
			<form:errors path="password" class="fail"/>
			<form:password class="input" path="password"/>
			<br> 
			
			<label>Confirm Password: </label>
			<form:errors path="confirm" class="fail"/>
			<form:password class="input" path="confirm"/>
			<br> 
			
			<input class="input" type="submit" value="Submit"/>
			
		
		
		</form:form>
		</div>
		<div id="login"> 
		<h2>Log In</h2>
		
		<form:form action="/login" method="post" modelAttribute="newLogin">
			
			<label>Email: </label>
			<form:errors path="email" class="fail"/> 
			<form:input class="input" path="email"/>
			<br> 
			
			<label>Password: </label>
			<form:errors path="password" class="fail"/> 
			<form:password class="input" path="password"/>
			<br> 
			
			<input class="input" type="submit" value="Submit"/>
		</form:form>
		</div>
		</div>
</body>
</html>